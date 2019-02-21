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
 import org.springframework.web.bind.annotation.*;

 import javax.servlet.http.HttpServletRequest;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2019/1/22
  */
 @RestController
 @RequestMapping(value = "/categories")
 public class CategoriesController {
     
     @Autowired
     CategoriesService categoriesService;
     @Autowired
     ArticleService articleService;
     /**
      * 查找所有分类
      * @return
      */
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
     /**
      * 获得分类下的所有文章
      * @return
      */
     @PostMapping("/getCategoryArticle")
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
    
     /**
      * 获得所有分类名以及每个分类名的文章数目
      * @return
      */
     @GetMapping("/findCategoriesNameAndArticleNum")
     public JSONObject findCategoriesNameAndArticleNum(){
        
         return categoriesService.findCategoriesNameAndArticleNum();
     }
     /**
      * 通过id查找categoryName
      *
      */
     @RequestMapping("/selectCategoryNameById")
     public JSONObject selectCategoryNameById(Integer id){
         JSONObject jsonObject = new JSONObject();
         try {
             String categoryName = categoriesService.selectCategoryNameById(id);
             jsonObject.put("code:","200");
             jsonObject.put("data",categoryName);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:","500");
         }
         return jsonObject;
     }
     
     /**
      * 插入分类记录
      */
     @RequestMapping("/insertCategoriesRecord")
     public JSONObject insertCategoriesRecord(String categoryName){
         JSONObject jsonObject = new JSONObject();
         Categories categories = new Categories();
         categories.setCategoryname(categoryName);
         try {
             int status = categoriesService.insertCategories(categories);
             jsonObject.put("code:","200");
             jsonObject.put("msg:","插入成功");
             jsonObject.put("data",status);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:","500");
         }
         return jsonObject;
     }
     /**
      * 通过分类名删除分类
      *
      */
     @RequestMapping("/deleteByCategoryName")
     public JSONObject deleteByCategoryName(String categoryName){
         JSONObject jsonObject = new JSONObject();
         try {
             int status = categoriesService.deleteByCategoryName(categoryName);
             jsonObject.put("code:","200");
             jsonObject.put("data",status);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:","500");
         }
         return jsonObject;
     }
 }
