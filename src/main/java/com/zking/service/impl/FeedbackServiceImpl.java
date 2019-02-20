 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.alibaba.fastjson.JSONArray;
 import com.alibaba.fastjson.JSONObject;
 import com.github.pagehelper.PageHelper;
 import com.github.pagehelper.PageInfo;
 import com.zking.entity.Feedback;
 import com.zking.mapper.FeedbackMapper;
 import com.zking.service.FeedbackService;
 import com.zking.service.UserService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2019/1/23
  */
 @Service
 public class FeedbackServiceImpl implements FeedbackService {
     @Autowired
     FeedbackMapper feedbackMapper;
     @Autowired
     UserService userService;
     
     
     @Override
     public int insertFeedback(Feedback feedback) {
         
         
         return feedbackMapper.insert(feedback);
     }
    
     
     
     @Override
     public JSONObject getAllFeedback(int rows, int pageNum) {
         PageHelper.startPage(pageNum, rows);
         List<Feedback> feedBacks = feedbackMapper.getAllFeedback();
         PageInfo<Feedback> pageInfo = new PageInfo<>(feedBacks);
    
         JSONObject returnJson = new JSONObject();
         returnJson.put("status",200);
         JSONArray jsonArray = new JSONArray();
         JSONObject feedbackJson;
    
         for(Feedback feedBack : feedBacks){
             feedbackJson = new JSONObject();
             feedbackJson.put("feedbackContent", feedBack.getFeedbackcontent());
             feedbackJson.put("person", userService.findUsernameById(feedBack.getPersonid()));
             feedbackJson.put("feedbackDate", feedBack.getFeedbackdate());
             if(feedBack.getContactinfo() == null){
                 feedbackJson.put("contactInfo", "");
             } else {
                 feedbackJson.put("contactInfo", feedBack.getContactinfo());
             }
             jsonArray.add(feedbackJson);
         }
    
         returnJson.put("result",jsonArray);
    
         JSONObject pageJson = new JSONObject();
         pageJson.put("pageNum",pageInfo.getPageNum());
         pageJson.put("pageSize",pageInfo.getPageSize());
         pageJson.put("total",pageInfo.getTotal());
         pageJson.put("pages",pageInfo.getPages());
         pageJson.put("isFirstPage",pageInfo.isIsFirstPage());
         pageJson.put("isLastPage",pageInfo.isIsLastPage());
         returnJson.put("pageInfo",pageJson);
         return returnJson;
     }
 }
