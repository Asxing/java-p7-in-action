package com.holddie.redis.standalone;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.sync.RedisCommands;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Profile("standalone")
public class RedisConfiguration {

	@Value("${spring.redis.host}")
	private String redisHost;

	@Value("${spring.redis.port}")
	private int redisPort;

	@Value("${spring.redis.password}")
	private String redisPwd;

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(redisHost);
		jedisConnectionFactory.setPassword(redisPwd);
		jedisConnectionFactory.setPort(redisPort);
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		return redisTemplate;
	}

	@Bean("JedisClient")
	public Jedis JedisClient() {
		return new Jedis(redisHost, redisPort);
	}

	@Bean("lettuceClient")
	public RedisClient lettuceClient() {
		RedisURI redisURI = new RedisURI();
		redisURI.setHost(redisHost);
		redisURI.setPort(redisPort);
		redisURI.setPassword((CharSequence) redisPwd);
		return RedisClient.create(redisURI);
	}

	@Bean("lettuceRedisCommand")
	public RedisCommands<String, String> redisCommands(RedisClient redisClient) {
		return redisClient.connect().sync();
	}


	@Bean("redissonClient")
	public RedissonClient redissonClient() {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://" + redisHost + ":" + redisPort);
		config.setCodec(new org.redisson.client.codec.StringCodec());
		return Redisson.create(config);
	}

}
