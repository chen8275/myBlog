 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.config;

 import org.springframework.context.annotation.Configuration;
 import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

 /**
  * @auther chendesheng
  * @date 2019/1/10
  */
 @Configuration
 public class InterceptorConfig extends WebMvcConfigurerAdapter {
    
     @Override
     public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/**").excludePathPatterns("/front/login","/front/loginPage","/front/register","/user/**","/fish/**","/shop/**");
         super.addInterceptors(registry);
     }
 }
