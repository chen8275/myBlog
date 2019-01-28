 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.zking.service.LeaveMessageService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.springframework.beans.factory.annotation.Autowired;
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
    
    
     @RequestMapping(value = "/getUserLeaveMessage")
     public ResultModel getUserLeaveMessage(int answererId){
         try {
             return leaveMessageService.getUserLeaveMessage(answererId);
         }catch (Exception e){
             return ResultTools.result(404,e.getMessage(),null);
         }
        
     }
     
 }
