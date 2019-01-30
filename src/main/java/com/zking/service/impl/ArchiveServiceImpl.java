 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.zking.entity.Archives;
 import com.zking.mapper.ArchivesMapper;
 import com.zking.service.ArchiveService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 /**
  * @auther chendesheng
  * @date 2019/1/29
  */
 @Service
 public class ArchiveServiceImpl implements ArchiveService {
     @Autowired
     ArchivesMapper archivesMapper;
     
     @Override
     public void addArchiveName(String archiveName) {
         
         int archiveNameIsExit = archivesMapper.findArchiveNameByArchiveName(archiveName);
         if(archiveNameIsExit == 0){
             archivesMapper.addArchiveName(archiveName);
         }
     }
    
     @Override
     public int insert(Archives archives) {
         return archivesMapper.insert(archives);
     }
 }
