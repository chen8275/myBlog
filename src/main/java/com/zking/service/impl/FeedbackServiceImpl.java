 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.zking.entity.Feedback;
 import com.zking.mapper.FeedbackMapper;
 import com.zking.service.FeedbackService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 /**
  * @auther chendesheng
  * @date 2019/1/23
  */
 @Service
 public class FeedbackServiceImpl implements FeedbackService {
     @Autowired
     FeedbackMapper feedbackMapper;
     
     @Override
     public int insertFeedback(Feedback feedback) {
         
         
         return feedbackMapper.insert(feedback);
     }
 }
