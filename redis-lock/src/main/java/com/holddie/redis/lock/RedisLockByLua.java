package com.holddie.redis.lock;

import java.util.Collections;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisLockByLua {

    @Autowired private JedisPool jedisPool;

    public boolean lock(String lockKey, String uid, int seconds) {
        try (Jedis jedis = jedisPool.getResource()) {
            SetParams setParams = SetParams.setParams().ex(seconds).nx();
            return "OK".equals(jedis.set(lockKey, uid, setParams));
        }
    }

    public boolean release(String lockKey, String uid) {
        String luaScript =
                "if redis.call('get',KEYS[1]) == ARGV[1] then "
                        + "return redis.call('del',KEYS[1]) else return 0 end";
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.eval(
                            luaScript,
                            Collections.singletonList(lockKey),
                            Collections.singletonList(uid))
                    .equals(1L);
        }
    }
}
