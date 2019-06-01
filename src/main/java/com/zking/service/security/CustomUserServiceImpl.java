/*
 */
/*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  *//*

 package com.zking.service.security;

 import com.zking.entity.Role;
 import com.zking.entity.User;
 import com.zking.mapper.UserMapper;
 import com.zking.service.UserService;
 import com.zking.util.TimeUtil;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.authority.SimpleGrantedAuthority;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.stereotype.Service;

 import java.util.ArrayList;
 import java.util.List;

 */
/**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/6/1 10:12
  *//*

 @Service
 public class CustomUserServiceImpl implements UserDetailsService {
     @Autowired
     UserService userService;
     @Autowired
     UserMapper userMapper;
     
     
     @Override
     public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
         User user = userMapper.findByUserName(userName);
        
         if(user == null){
             throw  new UsernameNotFoundException("用户不存在");
         }
        
         TimeUtil timeUtil = new TimeUtil();
         String recentlyLanded = timeUtil.getFormatDateForSix();
         userService.updateRecentlyLanded(user.getUsername(), recentlyLanded);
         List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
         for(Role role : user.getRoles()){
             authorities.add(new SimpleGrantedAuthority(role.getName()));
         }
        
         return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
     }
 }
*/
