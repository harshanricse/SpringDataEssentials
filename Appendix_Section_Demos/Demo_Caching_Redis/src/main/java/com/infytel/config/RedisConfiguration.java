package com.infytel.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import redis.embedded.RedisServer;

@Configuration
public class RedisConfiguration {

 
    
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
          .entryTtl(Duration.ofMinutes(60))
          .disableCachingNullValues()
          .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
          .withCacheConfiguration("itemCache",
            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)))
          .withCacheConfiguration("customerCache",
            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
    }
    private RedisServer redisServer;
    
    public RedisConfiguration() {
        this.redisServer = new RedisServer(6370); 
    }
    
    @PostConstruct
    public void postConstruct() {
    	redisServer.start();
    }
    
    @PreDestroy
    public void predestroy()
    {
    	 redisServer.stop();
    }

    
    
    
}
