 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.zking.entity.Categories;
 import com.zking.service.CategoriesService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

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
 }
