package com.holddie.redis;

import com.holddie.redis.rest.UserResource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RedisLockApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RedisLockApplication.class);
        UserResource userResource = run.getBean(UserResource.class);
        userResource.execRedisCommand();
    }
}
