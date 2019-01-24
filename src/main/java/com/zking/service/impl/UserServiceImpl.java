 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.zking.entity.User;
 import com.zking.mapper.UserMapper;
 import com.zking.service.UserService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 /**
  * @auther chendesheng
  * @date 2019/1/18
  */
 @Service
 public class UserServiceImpl implements UserService{
     @Autowired
     UserMapper userMapper;
     
     @Override
     public User selectByUsernameAndPassword(String username, String password) {
         return userMapper.selectByUsernameAndPassword(username,password);
     }
    
     @Override
     public int insertSelective(User user) {
         return userMapper.insertSelective(user);
     }
    
     @Override
     public int updateByPrimaryKeySelective(User user) {
         return userMapper.updateByPrimaryKeySelective(user);
     }
    
     @Override
     public int findUserIdByUsername(String username) {
         return userMapper.findUserIdByUsername(username);
     }
    
 }
