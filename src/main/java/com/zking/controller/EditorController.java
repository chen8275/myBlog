 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.component.StringAndArray;
 import com.zking.entity.Article;
 import com.zking.service.ArticleService;
 import com.zking.util.BuildArticleTabloidUtil;
 import com.zking.util.TimeUtil;
 import io.swagger.annotations.Api;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;

 import javax.servlet.http.HttpServletRequest;

 /**
  * @auther chendesheng
  * @date 2019/1/29
  */
 @Api(value = "编辑操作",description = "详细描述")
 @Controller
 @RequestMapping(value = "/editor")
 public class EditorController {
     private Logger logger = LoggerFactory.getLogger(EditorController.class);
     
     @Autowired
     ArticleService articleService;
     
     /**
      * 发表博客
      * @param article 文章
      * @param request httpServletRequest
      * @return
      */
     @PostMapping("/publishArticle")
     @ResponseBody
     public JSONObject publishArticle(Article article, HttpServletRequest request){
         String userName = "chen";
         JSONObject returnJson = new JSONObject();
         
         
         /*String userName = null ;
         JSONObject returnJson = new JSONObject();
         try { 
             userName = request.getSession().getAttribute("userName").toString();
         }catch (NullPointerException e){
             //登录超时情况
             logger.error("This user is not login，publish article 《" + article.getArticletitle() +  "》 fail");
             returnJson.put("status",403);
             request.getSession().setAttribute("article", article);
             return returnJson;
         }*/
         
         
         //获得文章html代码并生成摘要
         BuildArticleTabloidUtil buildArticleTabloidUtil = new BuildArticleTabloidUtil();
         String articleHtmlContent = buildArticleTabloidUtil.buildArticleTabloid(request.getParameter("articleHtmlContent"));
         article.setArticletabloid(articleHtmlContent + "...");
         String[] articleTags = request.getParameterValues("articleTagsValue");
         String[] tags = new String[articleTags.length+1];
         for(int i=0;i<articleTags.length;i++){
             //去掉可能出现的换行符
             articleTags[i] = articleTags[i].replaceAll("<br>","");
             tags[i] = articleTags[i];
         }
         tags[articleTags.length] = article.getArticletype();
         
      
         TimeUtil timeUtil = new TimeUtil();
         String id = request.getParameter("id");
         //修改文章
         if(!"".equals(id) && id != null){
             String updateDate = timeUtil.getFormatDateForThree();
             article.setArticletags(StringAndArray.arrayToString(tags));
             article.setUpdatedate(updateDate);
             article.setId(Integer.parseInt(id));
             article.setAuthor(userName);
             return articleService.updateArticleById(article);
             }
         String nowDate = timeUtil.getFormatDateForThree();
         long articleId = timeUtil.getLongTime();
    
         article.setArticleid(articleId);
         article.setAuthor(userName);
         article.setArticletags(StringAndArray.arrayToString(tags));
         article.setPublishdate(nowDate);
         article.setUpdatedate(nowDate);
    
         returnJson = articleService.insertArticle(article);
         return returnJson;   
     }
     
     
 }
