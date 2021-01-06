package com.holddie.redis.event;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
public class PubSubMain {

    public static final String CHANNEL_NAME = "MyChannel";
    public static final String REDIS_HOST = "127.0.0.1";
    public static final int REDIS_PORT = 6379;

    private static final JedisPoolConfig POOL_CONFIG = new JedisPoolConfig();
    private static final JedisPool JEDIS_POOL =
            new JedisPool(POOL_CONFIG, REDIS_HOST, REDIS_PORT, 0);

    public static void main(String[] args) {
        final Jedis subscriberJedis = JEDIS_POOL.getResource();
        final Jedis publisherJedis = JEDIS_POOL.getResource();
        final Subscriber subscriber = new Subscriber();
        // 订阅线程：接收消息
        new Thread(
                        () -> {
                            try {
                                log.info(
                                        "Subscribing to \"MyChannel\". This thread will be blocked.");
                                subscriberJedis.subscribe(subscriber, CHANNEL_NAME);
                                log.info("Subscription ended.");
                            } catch (Exception e) {
                                log.error("Subscribing failed.", e);
                            }
                        })
                .start();

        new Publisher(publisherJedis, CHANNEL_NAME).startPublish();
        publisherJedis.close();

        subscriber.unsubscribe();
        subscriberJedis.close();
    }
}
