 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service;
 
 import com.alibaba.fastjson.JSONObject;


 /**
  * @auther chendesheng
  * @date 2019/1/31
  */

 public interface TagService {
    
     /**
      * 获得标签云
      * @return
      */
     JSONObject findTagsCloud();
 }
