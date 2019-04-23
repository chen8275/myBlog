 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.zking.entity.Feedback;
 import com.zking.service.FeedbackService;
 import com.zking.service.UserService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import io.swagger.annotations.Api;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import javax.servlet.http.HttpServletRequest;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2019/1/23
  */
 @Api(value = "反馈操作",description = "详细描述")
 @RestController
 @RequestMapping(value = "/feedback")
 public class FeedbackController {
     private static final Logger log = LoggerFactory.getLogger(FeedbackController.class);
     
     @Autowired
     FeedbackService feedbackService;
     @Autowired
     UserService userService;
     
     @PostMapping(value = "/insertFeedback")
     public ResultModel insertFeedback(HttpServletRequest request,String feedbackContent,String contactInfo){
        try {
            
            String userName = request.getSession().getAttribute("userName").toString();
            int personId = userService.findUserIdByUsername(userName);
            Feedback feedback = new Feedback();
            feedback.setPersonid(personId);
            feedback.setFeedbackcontent(feedbackContent);
            feedback.setContactinfo(contactInfo);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            feedback.setFeedbackdate(sdf.format(new Date()));
            
            int status = feedbackService.insertFeedback(feedback);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("content",status);
            return ResultTools.result(200,"",map);
        }catch (Exception e){
            return ResultTools.result(404,e.getMessage(),null);
        }
    }
     
     
     
 }
