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
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import javax.servlet.http.HttpServletRequest;
 import java.util.HashMap;
 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2019/1/18
  */
 @Service
 public class UserServiceImpl implements UserService{
     @Autowired
     UserMapper userMapper;
     @Autowired
     UserService userService;
     
     @Override
     public User selectByUsernameAndPassword(String username, String password) {
         return userMapper.selectByUsernameAndPassword(username,password);
     }
    
     @Override
     public int insertSelective(User user) {
         return userMapper.insertSelective(user);
     }
     
     @Override
     public int findUserIdByUsername(String username) {
         return userMapper.findUserIdByUsername(username);
     }
    
     @Override
     public ResultModel updateByPrimaryKeySelective(String username,String password,Integer userId) {
         
         User user = new User();
         user.setId(userId);
         user.setUsername(username);
         user.setPassword(password);
         int status = userMapper.updateByPrimaryKeySelective(user);
         Map<String,Object> map = new HashMap<String,Object>();
         map.put("content",status);
         return ResultTools.result(200,"",map);
     }
     
     
    
 }
