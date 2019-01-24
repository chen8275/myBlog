 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.zking.entity.PrivateWord;
 import com.zking.mapper.PrivatewordMapper;
 import com.zking.service.PrivateWordService;
 import com.zking.service.UserService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.codehaus.groovy.runtime.RangeInfo;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2019/1/24
  */
 @Service
 public class PrivateWordServiceImpl implements PrivateWordService {
     @Autowired
     UserService userService;
     @Autowired
     PrivatewordMapper privatewordMapper;
     
     @Override
     public ResultModel publishPrivateWord(String privateWordContent, String username) {
         
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
         String publisherDate = sdf.format(new Date());
         
         int userId = userService.findUserIdByUsername(username);
         PrivateWord privateWord = new PrivateWord(privateWordContent,userId,publisherDate);
         int status = privatewordMapper.insert(privateWord);
         Map<String,Object> map = new HashMap<String,Object>();
         map.put("content",status);
         return ResultTools.result(200,"",map);
        
     }
 }
