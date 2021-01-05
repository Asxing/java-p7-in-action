package com.holddie.redis.service;

import io.lettuce.core.api.sync.RedisCommands;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceLettuceImpl implements UserService {

    @Autowired
    @Qualifier("lettuceRedisCommand")
    private RedisCommands redisCommands;

    @Override
    public void save(String userName, String password) {
        userName = genUserName(userName);
        log.info("lettuceClient save username:{}, password:{}", userName, password);
        redisCommands.set(userName, password);
    }

    @Override
    public void update(String userName, String password) {
        userName = genUserName(userName);
        log.info("lettuceClient update username:{}, password:{}", userName, password);
        redisCommands.set(userName, password);
    }

    private String genUserName(String userName) {
        return "lettuce:" + userName;
    }

    @Override
    public String get(String userName) {
        String password = String.valueOf(redisCommands.get(genUserName(userName)));
        log.info("lettuceClient get username: {}, password: {}", genUserName(userName), password);
        return password;
    }

    @Override
    public void delete(String userName) {
        log.info("lettuceClient username: {}", userName);
        redisCommands.del(genUserName(userName));
    }
}
