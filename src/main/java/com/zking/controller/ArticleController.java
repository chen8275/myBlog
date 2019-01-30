 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Article;
 import com.zking.service.ArticleService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 /**
  * @auther chendesheng
  * @date 2019/1/29
  */
 @RestController
 @RequestMapping(value = "/article")
 public class ArticleController {
     
     
     @Autowired
     ArticleService articleService;
     @RequestMapping("/insertArticle")
     public JSONObject insertArticle(@RequestBody Article article){
         JSONObject jsonObject = new JSONObject();
         try {
             int status = articleService.insert(article);

             jsonObject.put("msg:","插入成功");
             jsonObject.put("status:",status);
             
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:",500);
         }
         return jsonObject;
     }
     
     
     
     
     
     
     
     
 }
