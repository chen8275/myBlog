 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service;

 import com.zking.entity.User;
 import com.zking.util.ResultModel;

 import javax.servlet.http.HttpServletRequest;

 /**
  * @auther chendesheng
  * @date 2019/1/18
  */
 public interface UserService {
     User selectByUsernameAndPassword(String username,String password);
     int insertSelective(User user);
     int findUserIdByUsername(String username);
    
     ResultModel updateByPrimaryKeySelective(String username, String password, Integer userId);
     boolean usernameIsExit(String username);
     ResultModel savePersonalDate(User user,String username);
     ResultModel getUserPersonalInfoByUsername(String username);
     
     int updateByPrimaryKeySelective(User user);
     String findUsernameById(int id);
     int findIdByUsername(String username);
     int countUserNum();
 }
