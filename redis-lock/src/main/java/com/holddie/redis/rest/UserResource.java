package com.holddie.redis.rest;

import java.util.List;

import com.holddie.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("user")
public class UserResource {

    @Autowired private List<UserService> userServiceList;

    @GetMapping("redis/exec")
    public void execRedisCommand() {
        String username = "zhangsan";
        String password = "123456";
        log.info("==============================");
        userServiceList.forEach(
                userService -> {
                    userService.save(username, password);
                    log.info("get password:{}", userService.get(username));
                    log.info("get password:{}", userService.get(username));
                    userService.save(username, password + password);
                    log.info("get password:{}", userService.get(username));
                    log.info("get password:{}", userService.get(username));
                    userService.delete(username);
                    log.info("get password:{}", userService.get(username));
                    log.info("==============================");
                });
    }
}
