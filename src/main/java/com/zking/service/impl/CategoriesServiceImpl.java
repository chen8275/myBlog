 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.zking.entity.Categories;
 import com.zking.mapper.CategoriesMapper;
 import com.zking.service.CategoriesService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2019/1/22
  */
 @Service
 public class CategoriesServiceImpl implements CategoriesService {
     @Autowired
     CategoriesMapper categoriesMapper;
     @Override
     public List<Categories> list() {
         return categoriesMapper.listCategories();
     }
 }
