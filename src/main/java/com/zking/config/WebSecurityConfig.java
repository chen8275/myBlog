 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.config;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
                 .antMatchers("/front/superadmin").hasAnyRole("ADMIN")
                 .and()
                 .formLogin().loginPage("/front/login")
                 .failureUrl("/front/login_error")
                 .and()
                 .exceptionHandling().accessDeniedPage("/front/404");
         
         http.logout().logoutUrl("/front/logout");
         http.csrf().disable();
     }
     
     
     //内存中创建用户，用户名为chen，密码1234，权限为USER
     @Autowired
     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
         auth
                 .inMemoryAuthentication()
                 .withUser("chen").password("1234").roles("USER");
     }
     
     
 }
