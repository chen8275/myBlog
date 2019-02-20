 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.service.*;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import javax.servlet.http.HttpServletRequest;
 import java.security.Principal;


 /**
  * @auther chendesheng
  * @date 2019/2/19
  */
 @RestController
 @RequestMapping("/superAdmin")
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
     @GetMapping("/getArticleManagement")
     public JSONObject getArticleManagement(@RequestParam("rows") String rows,
                                            @RequestParam("pageNum") String pageNum){
        
         return articleService.getArticleManagement(Integer.parseInt(rows), Integer.parseInt(pageNum));
     }
     /**
      * 删除文章
      * @param id 文章id
      * @return 1--删除成功   0--删除失败
      */
     @GetMapping("/deleteArticle")
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
     @GetMapping("/getAllFeedback")
     public JSONObject getAllFeedback(@RequestParam("rows") String rows,
                                      @RequestParam("pageNum") String pageNum){
         return feedbackService.getAllFeedback(Integer.parseInt(rows),Integer.parseInt(pageNum));
     }
     
     /**
      * 获得所有悄悄话
      * @return
      */
     @PostMapping("/getAllPrivateWord")
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
    
    
 }
