 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.zking.mapper.VisitorMapper;
 import com.zking.service.VisitorService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 /**
  * @auther chendesheng
  * @date 2019/2/19
  */
 @Service
 public class VisitorServiceImpl implements VisitorService {
     @Autowired
     VisitorMapper visitorMapper;
     
     @Override
     public long getAllVisitor() {
         return visitorMapper.getAllVisitor();
     }
     
 }
