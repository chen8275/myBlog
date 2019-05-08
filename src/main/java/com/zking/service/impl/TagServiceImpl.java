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
 import lombok.extern.slf4j.Slf4j;
 import org.hibernate.engine.jdbc.internal.DDLFormatterImpl;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import java.util.List;
 import java.util.logging.Logger;

 /**
  * @auther chendesheng
  * @date 2019/1/31
  */
 @Service
 @Slf4j
 public class TagServiceImpl implements TagService {
     private org.slf4j.Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
     
     @Autowired
     TagsMapper tagsMapper;
     @Autowired
     TagService tagService;
     
     @Cacheable(cacheNames = "tags",key = "123")
     @Override
     public JSONObject findTagsCloud() {
         
         List<Tags> tags = tagsMapper.findTagsCloud();
         log.info("tagsCloud:[{}]",tags.size());
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("status",200);
         jsonObject.put("result",JSONArray.toJSON(tags));
         jsonObject.put("tagsNum",tags.size());
         return jsonObject;
     }
    
     @Override
     public int insertTag(Tags record) {
         return tagsMapper.insert(record);
     }
    
     @Override
     public void addTags(String tagName, int tagSize) {
         
         if(tagsMapper.findIsExitByTagName(tagName) == 0){
             Tags t = new Tags();
             t.setTagname(tagName);
             t.setTagsize(tagSize);
             tagsMapper.insert(t);
         }
     }
    
     @Override
     public Integer IsExitByTagName(String tagName) {
     
         return tagsMapper.findIsExitByTagName(tagName);
         
     }
    
     
     @Override
     public Tags selectById(Integer id) {
         return new Tags(id,"Java",20);
     }
    
    
 }
