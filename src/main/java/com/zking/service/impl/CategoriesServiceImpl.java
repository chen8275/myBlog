 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.alibaba.fastjson.JSONArray;
 import com.alibaba.fastjson.JSONObject;
 import com.github.pagehelper.PageHelper;
 import com.github.pagehelper.PageInfo;
 import com.zking.entity.Article;
 import com.zking.entity.Categories;
 import com.zking.mapper.CategoriesMapper;
 import com.zking.service.ArticleService;
 import com.zking.service.CategoriesService;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import javax.sound.midi.Soundbank;
 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2019/1/22
  */
 @Service
 public class CategoriesServiceImpl implements CategoriesService {
     private Logger logger = LoggerFactory.getLogger(CategoriesServiceImpl.class);
     
     @Autowired
     CategoriesMapper categoriesMapper;
     @Autowired
     ArticleService articleService;
     @Autowired
     CategoriesService categoriesService;
     
     
     @Override
     public List<Categories> list() {
         return categoriesMapper.listCategories();
     }
    
     @Override
     public int insertCategories(Categories categories) {
         return categoriesMapper.insert(categories);
     }
    
     @Override
     public JSONObject findCategoriesNameAndArticleNum() {
         
         List<String> categoryNames = categoriesMapper.findCategoriesName();
         JSONObject categoryJson;
         JSONArray categoryJsonArray = new JSONArray();
         JSONObject returnJson = new JSONObject();
         for(String categoryName : categoryNames){
             categoryJson = new JSONObject();
             categoryJson.put("categoryName",categoryName);
             categoryJson.put("categoryArticleNum",articleService.countArticleCategoryByCategory(categoryName));
             categoryJsonArray.add(categoryJson);
         }
         returnJson.put("status",200);
         returnJson.put("result",categoryJsonArray);
         return returnJson;
     }
    
     @Override
     public JSONObject getCategoriesManagement(int rows, int pageNum) {
         PageHelper.startPage(pageNum, rows);
         List<Categories> Categorieses = categoriesMapper.listCategories();
         PageInfo<Categories> pageInfo = new PageInfo<>(Categorieses);
         JSONArray returnJsonArray = new JSONArray();
         JSONObject returnJson = new JSONObject();
         JSONObject articleJson;
         for(Categories category : Categorieses){
             articleJson = new JSONObject();
             articleJson.put("id",category.getId());
             articleJson.put("categoryName",category.getCategoryname());
             returnJsonArray.add(articleJson);
         }
         returnJson.put("status",200);
         returnJson.put("result",returnJsonArray);
         JSONObject pageJson = new JSONObject();
         pageJson.put("pageNum",pageInfo.getPageNum());
         pageJson.put("pageSize",pageInfo.getPageSize());
         pageJson.put("total",pageInfo.getTotal());
         pageJson.put("pages",pageInfo.getPages());
         pageJson.put("isFirstPage",pageInfo.isIsFirstPage());
         pageJson.put("isLastPage",pageInfo.isIsLastPage());
    
         returnJson.put("pageInfo",pageJson);
    
         return returnJson;
     }
    
     @Override
     public int deleteCategories(Integer id) {
         try {
             
             //删除此分类下的文章，需要通过id获取categoryName
             String categoryName = categoriesService.selectCategoryNameById(id);
             articleService.deleteArticleByCategoryName(categoryName);
             //删除分类
             categoriesMapper.deleteByPrimaryKey(id);
             
         }catch (Exception e){
             logger.error("删除分类失败，分类id=" + id);
             return 0;
         }
         return 1;
     }
    
     @Override
     public String selectCategoryNameById(Integer id) {
         return categoriesMapper.selectCategoryNameById(id);
     }
    
     @Override
     public int deleteByCategoryName(String categoryName) {
         return categoriesMapper.deleteByCategoryName(categoryName);
     }
 }
