package com.holddie.redis.rest;

import java.util.List;

import com.holddie.redis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserResource {

    @Autowired private List<UserService> userServiceList;

    @GetMapping("redis/exec")
    public void execRedisCommand() {
        String username = "zhangsan";
        String password = "123456";
        userServiceList.forEach(
                userService -> {
                    userService.save(username, password);
                    userService.get(username);
                    userService.delete(username);
                    userService.get(username);
                });
    }
}
