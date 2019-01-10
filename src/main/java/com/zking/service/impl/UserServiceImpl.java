 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.github.pagehelper.PageHelper;
 import com.zking.dao.UserDao;
 import com.zking.entity.UserEntity;
 import com.zking.service.UserService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2019/1/10
  */
 @Service
 public class UserServiceImpl implements UserService {
     @Autowired
     UserDao userDao;
     @Override
     public List<UserEntity> getList(int pageNum, int pageSize) {
         
         List<UserEntity> list = userDao.findAll();
         return list;
     }
 }
