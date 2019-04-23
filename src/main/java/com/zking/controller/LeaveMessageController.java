 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Article;
 import com.zking.service.ArticleService;
 import com.zking.service.LeaveMessageService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import javax.servlet.http.HttpServletRequest;


 /**
  * @auther chendesheng
  * @date 2019/1/28
  */
 @RestController
 @RequestMapping(value = "/leaveMessage")
 public class LeaveMessageController {
     
     @Autowired
     LeaveMessageService leaveMessageService;
    
    
     /**
      * 发表留言
      * @param leaveMessageContent
      * @param pageName
      * @param request
      * @return
      */
     @PostMapping("/publishLeaveMessage")
     public JSONObject publishLeaveMessage(String leaveMessageContent, String pageName, HttpServletRequest request){
         String answerer = request.getSession().getAttribute("userName").toString();
         JSONObject jsonObject = new JSONObject();
         try {
             int status = leaveMessageService.insertLeaveMessage(leaveMessageContent,pageName,answerer);
             jsonObject.put("msg:","插入成功");
             jsonObject.put("status:",status);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:",500);
         }
         return jsonObject;
     }
     
    
 }
