 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Tags;
 import com.zking.service.ArticleService;
 import com.zking.service.TagService;
 import com.zking.util.TransCodingUtil;
 import io.swagger.annotations.Api;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import javax.servlet.http.HttpServletRequest;

 /**
  * @auther chendesheng
  * @date 2019/1/31
  */
 @Api(value = "标签操作",description = "详细描述")
 @RestController
 @RequestMapping(value = "/tags")
 public class TagsController {
     @Autowired
     TagService tagService;
     @Autowired
     ArticleService articleService;
    
     /**
      * 获得标签云
      * @return
      */
     @GetMapping("/getTagCloud")
     public JSONObject getTagCloud(){
         return tagService.findTagsCloud();
     }
    
    
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
    
     /**
      * 插入标签
      * @param tagName 标签名
      * @param tagSize 标签大小               
      * @return
      */
     @PostMapping("/insertTag")
     public JSONObject insertTag(String tagName,Integer tagSize){
         Tags tags = new Tags();
         tags.setTagname(tagName);
         tags.setTagsize(tagSize);
         JSONObject jsonObject = new JSONObject();
         try {
             int status = tagService.insertTag(tags);
             jsonObject.put("code:","200");
             jsonObject.put("data",status);
             jsonObject.put("msg:","插入成功");
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:","500");
         }
         return jsonObject;
     }
    
     /**
      * 判断标签是否存在
      *
      */
     @PostMapping("/IsExitByTagName")
     public JSONObject IsExitByTagName(String tagName){
         JSONObject jsonObject = new JSONObject();
         try {
             int status = tagService.IsExitByTagName(tagName);
             jsonObject.put("code:","200");
             jsonObject.put("data",status);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:","500");
         }
         return jsonObject;
     }
    
     /**
      * 测试redis
      * @param id
      * @return
      */
     @PostMapping("/selectById")
     public Tags getById(String id){
         Integer id2 = Integer.valueOf(id);
         return tagService.selectById(id2);
     }
     
     
 }
