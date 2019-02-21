 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service;
 
 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Tags;


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
     /**
      * 插入标签
      * @return
      */
     int insertTag(Tags record);
     /**
      * 加入标签
      * @param tags 一群标签
      * @param tagSize 标签大小
      */
     void addTags(String tags, int tagSize);
 }
