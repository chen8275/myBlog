 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service;

 import com.zking.entity.Archives;

 /**
  * @auther chendesheng
  * @date 2019/1/29
  */
 public interface ArchiveService {
     
     /**
      * 添加归档日期
      * @param archiveName
      */
     void addArchiveName(String archiveName);
     
     int insert(Archives archives);
 }
