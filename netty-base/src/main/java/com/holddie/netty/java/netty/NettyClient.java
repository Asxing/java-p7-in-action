package com.holddie.netty.java.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NettyClient {
    private final static int MAX_RETRY = 3;

    public static void main(String[] args) throws InterruptedException {
        String ip = "127.0.0.1";
        int port = 8080;
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                // 可以给客户端 Channel，也就是NioSocketChannel绑定自定义属性，然后我们可以通过channel.attr()取出这个属性
                .attr(AttributeKey.newInstance("clientAttrKey"), "clientAttrValue")
                // 表示连接的超时时间，超过这个时间还是建立不上的话则代表连接失败
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                // 表示是否开启 TCP 底层心跳机制，true 为开启
                .option(ChannelOption.SO_KEEPALIVE, true)
                // 表示是否开始 Nagle 算法，true 表示关闭，false 表示开启
                // 如果要求高实时性，有数据发送时就马上发送，就设置为 true 关闭，如果需要减少发送次数减少网络交互，就设置为 false 开启
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new StringEncoder());
                    }
                });
        Channel channel = bootstrap
                .connect(ip, port)
                .addListener(future -> {
                    if (future.isSuccess()) {
                        System.out.println("连接成功!");
                    } else {
                        System.out.println("连接失败!");
                        retry(bootstrap, ip, port, MAX_RETRY);
                    }
                })
                .channel();
        while (true && channel.isActive()) {
            String msg = new Date() + ": hello world!";
            System.out.println("send msg: " + msg);
            channel.writeAndFlush(msg);
            Thread.sleep(2000);
        }
    }

    private static void retry(Bootstrap bootstrap, String ip, int port, int retryCount) {
        bootstrap.connect(ip, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("success connected!");
            } else if (retryCount == 0) {
                System.out.println("the number of retries has been exhausted, please give up the connection.");
            } else {
                int order = (MAX_RETRY - retryCount) + 1;
                int delay = 1 << order;
                System.out.println(new Date() + ": connected fail, retry for the " + order + " times.");
                bootstrap.config().group().schedule(() ->
                        retry(bootstrap, ip, port, retryCount - 1), delay, TimeUnit.SECONDS);
            }
        });
    }
}
