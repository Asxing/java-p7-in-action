package com.holddie.redis.service;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceJedisImpl implements UserService {

    @Autowired private Jedis jedis;

    @Override
    public void save(String userName, String password) {
        userName = genUserName(userName);
        log.info("jedis save username:{}, password:{}", userName, password);
        jedis.set(userName, password);
    }

    @Override
    @CachePut(cacheNames = "user_details", key = "#userName")
    public void update(String userName, String password) {
        userName = genUserName(userName);
        log.info("jedis update username:{}, password:{}", userName, password);
        jedis.set(userName, password);
    }

    private String genUserName(String userName) {
        return "jedis:" + userName;
    }

    @Override
    @Cacheable(value = "user_details", key = "#userName", unless = "#result == null")
    public String get(String userName) {
        String password = jedis.get(genUserName(userName));
        log.info("jedis get username: {}, password: {}", genUserName(userName), password);
        return password;
    }

    @Override
    @CacheEvict(cacheNames = "user_details", key = "#userName")
    public void delete(String userName) {
        log.info("jedis delete username: {}", userName);
        jedis.del(genUserName(userName));
    }
}
