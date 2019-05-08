 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.config;
 import org.springframework.boot.context.properties.ConfigurationProperties;
 import org.springframework.cache.annotation.EnableCaching;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
 import org.springframework.data.redis.core.RedisTemplate;
 import org.springframework.data.redis.core.StringRedisTemplate;
 import redis.clients.jedis.JedisPoolConfig;


 /**
  * redis相关Bean的配置
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/4/22 21:02
  */
 @Configuration
 @EnableCaching
 public class RedisConfig{
    
    
     @Bean
     @ConfigurationProperties(prefix="spring.redis")
     public JedisPoolConfig getRedisConfig(){
         JedisPoolConfig config = new JedisPoolConfig();
         return config;
     }
    
     @Bean
     @ConfigurationProperties(prefix="spring.redis")
     public JedisConnectionFactory getConnectionFactory(){
         JedisConnectionFactory factory = new JedisConnectionFactory();
         JedisPoolConfig config = getRedisConfig();
         factory.setPoolConfig(config);
         return factory;
     }
    
    
     @Bean
     public RedisTemplate<?, ?> getRedisTemplate(){
         RedisTemplate<?,?> template = new StringRedisTemplate(getConnectionFactory());
         return template;
     }
   
    
     
    
 }
