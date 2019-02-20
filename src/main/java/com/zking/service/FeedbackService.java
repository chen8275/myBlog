 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Feedback;

 /**
  * @auther chendesheng
  * @date 2019/1/23
  */
 public interface FeedbackService {
     /**
      * 提交反馈
      * @return
      */
     int insertFeedback(Feedback feedback);
     /**
      * 获得所有的反馈
      * @return
      */
     JSONObject getAllFeedback(int rows, int pageNum);
 }
