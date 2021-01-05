package com.holddie.redis.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceRestTemplateImpl implements UserService {

    @Autowired private RedisTemplate redisTemplate;

    @Override
    public void save(String userName, String password) {
        userName = genUserName(userName);
        log.info("redisTemplate save username:{}, password:{}", userName, password);
        redisTemplate.opsForValue().set(userName, password);
    }

    @Override
    public void update(String userName, String password) {
        userName = genUserName(userName);
        log.info("redisTemplate update username:{}, password:{}", userName, password);
        redisTemplate.opsForValue().set(userName, password);
    }

    private String genUserName(String userName) {
        return "redisTemplate:" + userName;
    }

    @Override
    public String get(String userName) {
        String password = String.valueOf(redisTemplate.opsForValue().get(genUserName(userName)));
        log.info("redisTemplate get username: {}, password: {}", genUserName(userName), password);
        return password;
    }

    @Override
    public void delete(String userName) {
        log.info("redisTemplate delete username: {}", userName);
        redisTemplate.delete(genUserName(userName));
    }
}
