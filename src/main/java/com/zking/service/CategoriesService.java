 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Categories;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2019/1/22
  */
 public interface CategoriesService {
     
     /**
      * 获得所有分类信息
      * @return
      */
     List<Categories> list();
     /**
      * 插入分类记录
      * @return
      */
     int insertCategories(Categories categories);
     /**
      * 获得所有的分类以及该分类的文章总数
      * @return
      */
     JSONObject findCategoriesNameAndArticleNum();
     /**
      * 分页获得分类管理
      */
     JSONObject getCategoriesManagement(int rows, int pageNum);
     /**
      * 通过id删除分类
      * @param id 分类id
      * @return 1--删除成功  0--删除失败
      */
     @Transactional
     int deleteCategories(Integer id);
     /**
      * 通过id查找分类名
      * @param id 分类id
      * @return 1--删除成功  0--删除失败
      */
     String selectCategoryNameById(Integer id);
     /**
      * 通过categoryName删除分类
      * @param categoryName 分类名
      * @return 1--删除成功  0--删除失败
      */
     int deleteByCategoryName(String categoryName);
 }
