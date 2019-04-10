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
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;


 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

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
    
     @RequestMapping(value = "/listArticles")
     public ResultModel listArticles(){
         try {
             List<Article> articles = articleService.listArticles();
             Map<String,Object> map = new HashMap<String,Object>();
             map.put("content",articles);
             return ResultTools.result(200,"",map);
         }catch (Exception e){
             return ResultTools.result(404,e.getMessage(),null);
         }
     }
     
     @RequestMapping(value = "/getById")
     public ResultModel getById(Integer id){
         try {
             Article article = articleService.getById(id);
             Map<String,Object> map = new HashMap<String,Object>();
             map.put("content",article);
             return ResultTools.result(200,"",map);
         }catch (Exception e){
             return ResultTools.result(404,e.getMessage(),null);
         }
     }
    
     /**
      * 获得文章总数
      *
      */
     @RequestMapping("/countArticleNum")
     public JSONObject countArticleNum(){
         JSONObject jsonObject = new JSONObject();
         try {
             int num = articleService.countArticleNum();
             jsonObject.put("code:","200");
             jsonObject.put("data",num);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:","500");
         }
         return jsonObject;
     }
    
     /**
      * 通过分类名获取文章总数
      * @param categoryName
      */
     @RequestMapping("/countArticlesByCategoryName")
     public JSONObject countArticlesByCategoryName(String categoryName){
         JSONObject jsonObject = new JSONObject();
         try {
             int num = articleService.countArticleByCategoryName(categoryName);
             jsonObject.put("code:","200");
             jsonObject.put("data",num);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:","500");
         }
         return jsonObject;
     }
     
     
 }
