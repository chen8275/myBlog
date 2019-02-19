 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.service.ArticleService;
 import com.zking.service.UserService;
 import com.zking.service.VisitorService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 /**
  * @auther chendesheng
  * @date 2019/2/19
  */
 @RestController
 @RequestMapping("/superAdmin")
 public class SuperAdminController {
    
     @Autowired
     UserService userService;
     @Autowired
     ArticleService articleService;
     @Autowired
     VisitorService visitorService;
     
     /**
      * 获得统计信息
      * @return
      */
     @GetMapping("/getStatisticsInfo")
     public JSONObject getStatisticsInfo(){
         JSONObject returnJson = new JSONObject();
         long num = visitorService.getAllVisitor();
         
         returnJson.put("allVisitor", num);
         returnJson.put("allUser", userService.countUserNum());
         returnJson.put("yesterdayVisitor", num);
         returnJson.put("articleNum", articleService.countArticleNum());
         return returnJson;
     }
    
 }
