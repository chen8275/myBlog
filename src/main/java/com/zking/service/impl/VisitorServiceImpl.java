 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.mapper.VisitorMapper;
 import com.zking.service.VisitorService;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 /**
  * @auther chendesheng
  * @date 2019/2/19
  */
 @Service
 @Slf4j
 public class VisitorServiceImpl implements VisitorService {
     @Autowired
     VisitorMapper visitorMapper;
     
     

     @Override
     public long getAllVisitor() {
         return visitorMapper.getAllVisitor();
     }
    
     @Override
     public JSONObject getVisitorNumByPageName(String pageName) {
         long totalVisitor = visitorMapper.getVisitorNumByPageName("totalVisitor");
         long pageVisitor = visitorMapper.getVisitorNumByPageName(pageName);
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("totalVisitor", totalVisitor);
         jsonObject.put("pageVisitor", pageVisitor);
         return jsonObject;
     }
    
     @Override
     public long getNumByPageName(String pageName) {
         return visitorMapper.getVisitorNumByPageName(pageName);
     }
    
 }
