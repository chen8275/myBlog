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
 import com.zking.entity.Categories;
 import com.zking.mapper.CategoriesMapper;
 import com.zking.service.ArticleService;
 import com.zking.service.CategoriesService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2019/1/22
  */
 @Service
 public class CategoriesServiceImpl implements CategoriesService {
     
     @Autowired
     CategoriesMapper categoriesMapper;
     @Autowired
     ArticleService articleService;
     
     
     @Override
     public List<Categories> list() {
         return categoriesMapper.listCategories();
     }
    
     @Override
     public JSONObject findCategoriesNameAndArticleNum() {
         
         List<String> categoryNames = categoriesMapper.findCategoriesName();
         JSONObject categoryJson;
         JSONArray categoryJsonArray = new JSONArray();
         JSONObject returnJson = new JSONObject();
         for(String categoryName : categoryNames){
             categoryJson = new JSONObject();
             categoryJson.put("categoryName",categoryName);
             categoryJson.put("categoryArticleNum",articleService.countArticleCategoryByCategory(categoryName));
             categoryJsonArray.add(categoryJson);
         }
         returnJson.put("status",200);
         returnJson.put("result",categoryJsonArray);
         return returnJson;
     }
 }
