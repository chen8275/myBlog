 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.component;
 
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.security.core.authority.AuthorityUtils;
 import org.springframework.security.core.userdetails.User;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.stereotype.Component;

 /**
  * spring security登陆认证
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/4/12 14:29
  */
 @Component
 @Slf4j
 public class MyUserDetailsService implements UserDetailsService {
     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         log.info("用户的用户名: {}", username);
         // TODO 根据用户名，查找到对应的密码，与权限
        
         // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
         User user = new User(username, "123456",
                 AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
         return user;
     }

 }
