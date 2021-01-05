package com.holddie.redis.service;

public interface UserService {
    void save(String userName, String password);

    void update(String userName, String password);

    String get(String userName);

    void delete(String userName);
}
