package com.holddie.netty.java.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.AttributeKey;

public class NettyServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                // 可以给服务端的 channel，也就是NioServerSocketChannel指定一些自定义属性，然后我们可以通过channel.attr()取出这个属性
                .attr(AttributeKey.newInstance("serverAttrKey"), "serverAttrValue")
                // 可以给每一条连接指定自定义属性，然后后续我们可以通过channel.attr()取出该属性
                .childAttr(AttributeKey.newInstance("childAttrKey"), "childAttrValue")
                // 表示系统用于临时存放已完成三次握手的请求的队列的最大长度，如果连接建立频繁，服务器处理创建新连接较慢，可以适当调大这个参数
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 表示是否开启TCP底层心跳机制，true为开启
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 表示是否开启Nagle算法，true表示关闭，false表示开启，
                // 通俗地说，如果要求高实时性，有数据发送时就马上发送，就关闭，如果需要减少发送次数减少网络交互，就开启。
                .childOption(ChannelOption.TCP_NODELAY, true)
                // 服务启动过程中可以做一些操作
                .handler(
                        new ChannelInitializer<NioServerSocketChannel>() {
                            @Override
                            protected void initChannel(
                                    NioServerSocketChannel nioServerSocketChannel)
                                    throws Exception {
                                System.out.println("服务启动中。。。。。");
                            }
                        })
                .childHandler(
                        new ChannelInitializer<NioSocketChannel>() {
                            @Override
                            protected void initChannel(NioSocketChannel nioSocketChannel) {
                                nioSocketChannel.pipeline().addLast(new StringDecoder());
                                nioSocketChannel
                                        .pipeline()
                                        .addLast(
                                                new SimpleChannelInboundHandler<String>() {
                                                    @Override
                                                    protected void channelRead0(
                                                            ChannelHandlerContext
                                                                    channelHandlerContext,
                                                            String msg)
                                                            throws Exception {
                                                        System.out.println("receive msg: " + msg);
                                                    }
                                                });
                            }
                        })
                .bind(port)
                // 添加一个端口冲突递增的逻辑
                .addListener(
                        future -> {
                            if (future.isSuccess()) {
                                System.out.println("端口[" + port + "]绑定成功");
                            } else {
                                System.out.println("端口[" + port + "]绑定失败");
                                bind(serverBootstrap, port + 1);
                            }
                        });
    }

    private static void bind(ServerBootstrap serverBootstrap, int port) {
        serverBootstrap
                .bind(port)
                .addListener(
                        future -> {
                            if (future.isSuccess()) {
                                System.out.println("端口[" + port + "]绑定成功!");
                            } else {
                                System.err.println("端口[" + port + "]绑定失败!");
                                bind(serverBootstrap, port + 1);
                            }
                        });
    }
}
