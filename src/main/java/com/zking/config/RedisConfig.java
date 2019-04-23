 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.config;

 import com.fasterxml.jackson.annotation.JsonAutoDetect;
 import com.fasterxml.jackson.annotation.PropertyAccessor;
 import com.fasterxml.jackson.databind.ObjectMapper;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.cache.annotation.CachingConfigurerSupport;
 import org.springframework.cache.annotation.EnableCaching;
 import org.springframework.cache.interceptor.KeyGenerator;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

 /**
  * redis相关Bean的配置
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/4/22 21:02
  */
 @Configuration
 @EnableCaching
 public class RedisConfig extends CachingConfigurerSupport {
    
     
    
 }
