 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.config;

 import com.zking.entity.Tags;
 import org.springframework.cache.CacheManager;
 import org.springframework.cache.annotation.EnableCaching;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.data.redis.cache.RedisCacheManager;
 import org.springframework.data.redis.connection.RedisConnectionFactory;
 import org.springframework.data.redis.core.RedisTemplate;
 import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
 import java.net.UnknownHostException;
 import java.util.Arrays;
 import java.util.List;


 /**
  * redis相关Bean的配置
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/4/22 21:02
  */
 @Configuration
 @EnableCaching
 public class RedisConfig{
    
    
     @Bean("MyRedisTemplate")
     public RedisTemplate<Object, Object> myRedisTemplate(
             RedisConnectionFactory redisConnectionFactory)
             throws UnknownHostException {
         RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
         template.setConnectionFactory(redisConnectionFactory);
         Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
         template.setDefaultSerializer(jackson2JsonRedisSerializer);
         return template;
     }
     
     @SuppressWarnings("rawtypes")
     @Bean
     public CacheManager cacheManager(RedisTemplate redisTemplate) {
         RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
         // 多个缓存的名称,目前只定义了一个
         rcm.setCacheNames(Arrays.asList("thisredis"));
         //设置缓存过期时间(秒)
         rcm.setDefaultExpiration(600);
         return rcm;
     }
     
    
 }
