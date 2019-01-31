 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.service.ArticleService;
 import com.zking.service.TagService;
 import com.zking.util.TransCodingUtil;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;

 import javax.servlet.http.HttpServletRequest;

 /**
  * @auther chendesheng
  * @date 2019/1/31
  */
 @RestController
 @RequestMapping(value = "/tags")
 public class TagsController {
     @Autowired
     TagService tagService;
     @Autowired
     ArticleService articleService;
    
     /**
      * 分页获得该标签下的文章
      * @param tag
      * @return
      */
     @PostMapping("/getTagArticle")
     public JSONObject getTagArticle(@RequestParam("tag") String tag,
                                     HttpServletRequest request){
         try {
             
             tag = TransCodingUtil.unicodeToString(tag);
             
         } catch (Exception e){
         }
         if("".equals(tag)){
             return tagService.findTagsCloud();
         } else {
             int rows = Integer.parseInt(request.getParameter("rows"));
             int pageNum = Integer.parseInt(request.getParameter("pageNum"));
             return articleService.findArticleByTag(tag, rows, pageNum);
         }
     }
    
 }
