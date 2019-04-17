 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.config;

 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/4/12 10:22
  */
/* @Configuration
 @EnableWebSecurity*/
 public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
     
     @Override
     protected void configure(HttpSecurity http) throws Exception {
         http
                 .authorizeRequests()
                 .antMatchers("/front/show", "/front/index","/front/register","/front/addregister","/front/detail/*","/front/friendLink","/front/aboutme","/front/update","/front/tags","/front/categories").permitAll()
                 .anyRequest().authenticated()
                 .antMatchers("/front/user","/front/write","/front/saveArticle","/front/writeUpdate/*").hasAnyRole("USER")
                 .and()
                 .formLogin()
                 .loginPage("/front/login")
                 .loginProcessingUrl("/front/login")
                 .permitAll()
                 .and()
                 .logout().logoutUrl("/front/logout")
                 .permitAll();
         http.csrf().disable();
     }
 }
