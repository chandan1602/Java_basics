package com.example.redisDemo;

import com.example.redisDemo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@SpringBootApplication
public class RedisDemoApplication {

//	@Bean
//	public RedisCacheConfiguration cacheConfiguration() {
//		return RedisCacheConfiguration.defaultCacheConfig()
//				.entryTtl(Duration.ofMinutes(60))
//				.disableCachingNullValues()
//				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
//						new GenericJackson2JsonRedisSerializer()
//				));
//	}

	//Full Control Over caching setup
	@Bean
	public RedisCacheManagerBuilderCustomizer
			redisCacheManagerBuilderCustomizer() {
		return (builder) -> builder
				.withCacheConfiguration("itemCache",
	RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)))
				.withCacheConfiguration("customerCache",
	RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
	}

	@Bean
	RedisTemplate<String, User> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}

}
