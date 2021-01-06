package com.holddie.redis.event;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPubSub;

@Slf4j
public class Subscriber extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        log.info(String.format("Message. Channel: %s, Msg: %s", channel, message));
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        log.info(
                String.format(
                        "PMessage. Pattern: %s, Channel: %s, Msg: %s", pattern, channel, message));
        super.onPMessage(pattern, channel, message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        log.info("onSubscribe");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        log.info("onUnsubscribe");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        log.info("onPUnsubscribe");
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        log.info("onPSubscribe");
    }
}
