 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service;
 
 import com.alibaba.fastjson.JSONObject;
 import com.zking.util.ResultModel;
 import org.springframework.transaction.annotation.Transactional;

 /**
  * @auther chendesheng
  * @date 2019/1/24
  */
 public interface PrivateWordService {
    
     ResultModel publishPrivateWord(String privateWordContent, String username);
     /**
      * 获得所有悄悄内容
      * @return
      */
     JSONObject getAllPrivateWord();
     /**
      * 回复悄悄话
      * @param replyContent 回复内容
      * @param username 回复人
      * @return
      */
     @Transactional
     JSONObject replyPrivateWord(String replyContent, String username, int id);
    
 }
