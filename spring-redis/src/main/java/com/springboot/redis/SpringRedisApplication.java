package com.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching
//@EnableTransactionManagement
public class SpringRedisApplication {

//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @PostConstruct
//    @SuppressWarnings("unchecked")
//    public void initRedisSerialization(){
//        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
//        redisTemplate.setStringSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//    }


    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class, args);
    }

}
