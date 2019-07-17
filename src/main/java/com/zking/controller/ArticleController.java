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
 import io.swagger.annotations.Api;
 import io.swagger.annotations.ApiOperation;
 import lombok.extern.slf4j.Slf4j;
 import net.sf.json.JSONArray;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.web.bind.annotation.*;


 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2019/1/29
  */
 @Api(value = "文章操作",description = "详细描述")
 @RestController
 @RequestMapping(value = "/article")
 @Slf4j
 public class ArticleController {
     
     @Autowired
     ArticleService articleService;
    
     /**
      * 新增文章
      * @param article
      * @return
      */
     @ApiOperation(value = "新增文章",notes = "新增文章")
     @PostMapping("/insertArticle")
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
    
     /**
      * 获取所有文章
      * @return
      */
     @ApiOperation(value = "获取所有文章",notes = "获取所有文章")
     @GetMapping(value = "/listArticles")
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
     
     
     /**
      * 分页获得当前页文章
      * @param rows 一页的大小
      * @param pageNum 当前页
      */
     @ApiOperation(value = "分页获得当前页文章",notes = "分页获得当前页文章")
     @PostMapping("/myArticles")
     public @ResponseBody JSONArray myArticles(@RequestParam("rows") String rows,
                          @RequestParam("pageNum") String pageNum){
        
         return articleService.findAllArticles(rows, pageNum);
        
     }
    
     /**
      * 根据id获得文章
      * @param id
      * @return
      */
     @ApiOperation(value = "根据id获得文章",notes = "根据id获得文章")
     @PostMapping(value = "/getById")
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
      * @return
      */
     @ApiOperation(value = "获得文章总数",notes = "获得文章总数")
     @Cacheable(cacheNames = "article",key = "123")
     @GetMapping("/countArticleNum")
     public JSONObject countArticleNum(){
         JSONObject jsonObject = new JSONObject();
         try {
             int num = articleService.countArticleNum();
             log.info("articleNums:[{}]",num);
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
     @ApiOperation(value = "通过分类名获取文章总数",notes = "通过分类名获取文章总数")
     @PostMapping("/countArticlesByCategoryName")
     public JSONObject countArticlesByCategoryName(String categoryName){
         JSONObject jsonObject = new JSONObject();
         try {
             int num = articleService.countArticleByCategoryName(categoryName);
             log.info("articleByCategoryNum:[{}],categoryName:[{}]",num,categoryName);
             jsonObject.put("code:","200");
             jsonObject.put("data",num);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:","500");
         }
         return jsonObject;
     }
     
     
 }
