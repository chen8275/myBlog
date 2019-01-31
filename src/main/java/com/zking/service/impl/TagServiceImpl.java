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
 import com.sun.xml.internal.ws.developer.Serialization;
 import com.zking.entity.Tags;
 import com.zking.mapper.TagsMapper;
 import com.zking.service.TagService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2019/1/31
  */
 @Service
 public class TagServiceImpl implements TagService {
    
     @Autowired
     TagsMapper tagsMapper;
     @Override
     public JSONObject findTagsCloud() {
         List<Tags> tags = tagsMapper.findTagsCloud();
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("status",200);
         jsonObject.put("result",JSONArray.toJSON(tags));
         jsonObject.put("tagsNum",tags.size());
         return jsonObject;
     }
 }
