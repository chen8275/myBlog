 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.service.VisitorService;
 import io.swagger.annotations.Api;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 /**
  * @auther chendesheng
  * @date 2019/2/19
  */
 @Api(value = "游客操作",description = "详细描述")
 @RestController
 @RequestMapping(value = "/visitor")
 public class VisitorController {
     
     @Autowired
     VisitorService visitorService;
    
     /**
      * 获得访问总数
      *
      */
     @GetMapping("/getAllVisitor")
     public JSONObject getAllVisitor(){
         JSONObject jsonObject = new JSONObject();
         try {
             long num = visitorService.getAllVisitor();
             jsonObject.put("code:","200");
             jsonObject.put("data",num);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:","500");
         }
         return jsonObject;
     }
     
 }
