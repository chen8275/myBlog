 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Categories;
 import com.zking.service.ArticleService;
 import com.zking.service.CategoriesService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import com.zking.util.TransCodingUtil;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;

 import javax.servlet.http.HttpServletRequest;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2019/1/22
  */
 @RestController
 @RequestMapping(value = "/Categories")
 public class CategoriesController {
     
     @Autowired
     CategoriesService categoriesService;
     @Autowired
     ArticleService articleService;
     
     @RequestMapping(value = "/listCategories")
     public ResultModel selectUserByAll(){
        try {
            List<Categories> categories = categoriesService.list();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("content",categories);
            return ResultTools.result(200,"",map);
        }catch (Exception e){
            return ResultTools.result(404,e.getMessage(),null);
        }
    }
    
     @GetMapping("/getCategoryArticle")
     public JSONObject getCategoryArticle(@RequestParam("category") String category,
                                          HttpServletRequest request){
        
         try {
             category = TransCodingUtil.unicodeToString(category);
         } catch (Exception e){
         }
         int rows = Integer.parseInt(request.getParameter("rows"));
         int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        
         return articleService.findArticleByCategory(category, rows, pageNum);
     }
 }
