 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service;

 import com.alibaba.fastjson.JSONObject;

 /**
  * @auther chendesheng
  * @date 2019/2/19
  */
 public interface VisitorService {
    
     /**
      * 获得总访问量
      * @return
      */
     long getAllVisitor();
     /**
      * 通过页名获得总访问量和访客量
      * @param pageName 页名
      * @return
      */
     JSONObject getVisitorNumByPageName(String pageName);
     /**
      * 通过页名获得访客量
      * @param pageName 页名
      * @return 访客量
      */
     long getNumByPageName(String pageName);
 }
