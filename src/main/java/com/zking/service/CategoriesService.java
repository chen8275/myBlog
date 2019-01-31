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
      * 获得所有的分类以及该分类的文章总数
      * @return
      */
     JSONObject findCategoriesNameAndArticleNum();
 }
