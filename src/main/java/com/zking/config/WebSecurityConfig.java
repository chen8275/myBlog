 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.config;


 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/4/9 18:58
  */
 @Configuration
 @EnableGlobalMethodSecurity(prePostEnabled = true)
 public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     
     @Override
     protected void configure(HttpSecurity http) throws Exception {
         http
                 .authorizeRequests()
                 .antMatchers("/","/index","/aboutme","/archives","/categories","/friendLink","/tags","/update")
                 .permitAll()
                 .antMatchers("/mylove","/editor","/user").hasAnyRole("USER")
                 .antMatchers("/ali").hasAnyRole("ADMIN")
                 .antMatchers("/superadmin").hasAnyRole("SUPERADMIN")
                 .and()
                 .formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/")
                 .and()
                 .logout().logoutUrl("/logout").logoutSuccessUrl("/");
        
         http.csrf().disable();
     }
 }
