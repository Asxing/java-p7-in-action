package com.holddie.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceRedissionImpl implements UserService {

    @Autowired
    @Qualifier("redissonClient")
    private RedissonClient redissonClient;

    @Override
    public void save(String userName, String password) {
        userName = genUserName(userName);
        log.info("redissonClient save username:{}, password:{}", userName, password);
        RBucket<Object> bucket = redissonClient.getBucket(userName);
        bucket.set(password);
    }

    @Override
    public void update(String userName, String password) {
        userName = genUserName(userName);
        log.info("redissonClient update username:{}, password:{}", userName, password);
        RBucket<Object> bucket = redissonClient.getBucket(userName);
        bucket.set(password);
    }

    private String genUserName(String userName) {
        return "redission:" + userName;
    }

    @Override
    public String get(String userName) {
        String password = String.valueOf(redissonClient.getBucket(genUserName(userName)).get());
        log.info("redissonClient get username: {}, password: {}", genUserName(userName), password);
        return password;
    }

    @Override
    public void delete(String userName) {
        log.info("redissonClient username: {}", userName);
        RBucket<Object> bucket = redissonClient.getBucket(genUserName(userName));
        bucket.delete();
    }
}
