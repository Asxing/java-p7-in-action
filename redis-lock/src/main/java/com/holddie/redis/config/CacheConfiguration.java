package com.holddie.redis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfiguration {
    @Bean(name = "myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            //			StringBuilder builder = new StringBuilder();
            //			builder.append(target.getClass().getName()); // 类名
            //			builder.append(method.getName()); // 方法名
            //			for (Object param : params) { // 参数
            //				builder.append(param);
            //			}
            //			return builder.toString();
            return "jedis:" + params[0];
        };
    }
}
