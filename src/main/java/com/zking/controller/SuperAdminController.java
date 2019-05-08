 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import ch.qos.logback.classic.pattern.LineOfCallerConverter;
 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Categories;
 import com.zking.service.*;
 import io.swagger.annotations.Api;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.web.bind.annotation.*;
 import sun.rmi.runtime.Log;

 import javax.servlet.http.HttpServletRequest;



 /**
  * @auther chendesheng
  * @date 2019/2/19
  */
 @Api(value = "超级管理操作",description = "详细描述")
 @RestController
 @RequestMapping("/superAdmin")
 @Slf4j
 public class SuperAdminController {
    
     @Autowired
     UserService userService;
     @Autowired
     ArticleService articleService;
     @Autowired
     VisitorService visitorService;
     @Autowired
     FeedbackService feedbackService;
     @Autowired
     PrivateWordService privateWordService;
     @Autowired
     CategoriesService categoriesService;
     
     /**
      * 获得统计信息
      * @return
      */
     @Cacheable(cacheNames = "admin",key = "123")
     @GetMapping("/getStatisticsInfo")
     public JSONObject getStatisticsInfo(){
         JSONObject returnJson = new JSONObject();
         long num = visitorService.getAllVisitor();
         returnJson.put("allVisitor", num);
         returnJson.put("allUser", userService.countUserNum());
         returnJson.put("yesterdayVisitor", num);
         returnJson.put("articleNum", articleService.countArticleNum());
         return returnJson;
     }
     
     /**
      * 获得文章管理
      * @return
      */
     @PostMapping("/getArticleManagement")
     public JSONObject getArticleManagement(@RequestParam("rows") String rows,
                                            @RequestParam("pageNum") String pageNum){
        
         return articleService.getArticleManagement(Integer.parseInt(rows), Integer.parseInt(pageNum));
     }
     
     
     /**
      * 删除文章
      * @param id 文章id
      * @return 1--删除成功   0--删除失败
      */
     @PostMapping("/deleteArticle")
     public int deleteArticle(@RequestParam("id") String id){
         if("".equals(id) || id == null){
             return 0;
         }
         return articleService.deleteArticle(Integer.parseInt(id));
     }
     
     /**
      * 分页获得所有反馈信息
      * @param rows 一页大小
      * @param pageNum 当前页
      */
     @PostMapping("/getAllFeedback")
     public JSONObject getAllFeedback(@RequestParam("rows") String rows,
                                      @RequestParam("pageNum") String pageNum){
         return feedbackService.getAllFeedback(Integer.parseInt(rows),Integer.parseInt(pageNum));
     }
     
     
     /**
      * 获得所有悄悄话
      * @return
      */
     @GetMapping("/getAllPrivateWord")
     public JSONObject getAllPrivateWord(){
         return privateWordService.getAllPrivateWord();
     }
     
     /**
      * 回复悄悄话
      * @return
      */
     @PostMapping("/replyPrivateWord")
     public JSONObject replyPrivateWord(HttpServletRequest request,
                                        @RequestParam("replyContent") String replyContent,
                                        @RequestParam("id") String id){
         String username;
         JSONObject jsonObject;
         try {
             username = request.getSession().getAttribute("userName").toString();
         } catch (NullPointerException e){
             jsonObject = new JSONObject();
             jsonObject.put("status",403);
             return jsonObject;
         }
         return privateWordService.replyPrivateWord(replyContent, username, Integer.parseInt(id));
     }
    
     /**
      * 获得分类管理
      * @return
      */
     @GetMapping("/getCategoriesManagement")
     public JSONObject getCategoriesManagement(
                                            @RequestParam("rows") String rows,
                                            @RequestParam("pageNum") String pageNum){
         
         return categoriesService.getCategoriesManagement(Integer.parseInt(rows), Integer.parseInt(pageNum));
     }
     
     /**
      * 删除分类
      * @param id 分类id
      * @return 1--删除成功   0--删除失败
      */
     @GetMapping("/deleteCategories")
     public int deleteCategories(@RequestParam("id") String id){
         if("".equals(id) || id == null){
             return 0;
         }
         return categoriesService.deleteCategories(Integer.parseInt(id));
     }
     
     /**
      * 通过categoryName删除文章
      * @param categoryName 文章categoryName
      * @return 1--删除成功   0--删除失败
      */
     @PostMapping("/deleteArticlesByCategoryName")
     public int deleteArticlesByCategoryName(@RequestParam("categoryName") String categoryName){
         if("".equals(categoryName) || categoryName == null){
             return 0;
         }
         return articleService.deleteArticleByCategoryName(categoryName);
     }
     
     /**
      * 编辑文章
      * @param id 文章id
      * @param categoryName 分类名
      * @return 1--编辑成功   0--编辑失败
      */
     @GetMapping("/editorCategoryNameById")
     public int editorCategoryNameById(@RequestParam("id") int id,@RequestParam("categoryName") String categoryName){
         if("".equals(id) || id == 0||"".equals(categoryName) || categoryName == null){
             return 0;
         }
         Categories categories = new Categories();
         categories.setId(id);
         categories.setCategoryname(categoryName);
         
         return categoriesService.updateCategoryNameById(categories);
     }
 }
