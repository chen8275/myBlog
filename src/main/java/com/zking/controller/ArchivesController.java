 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Archives;
 import com.zking.service.ArchiveService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 /**
  * @auther chendesheng
  * @date 2019/1/30
  */
 @RestController
 @RequestMapping(value = "/archives")
 public class ArchivesController {
     
     @Autowired
     ArchiveService archiveService;
     @PostMapping("/insertArchive")
     public JSONObject insertArchive(@RequestBody Archives archives){
         JSONObject jsonObject = new JSONObject();
         try {
             int status = archiveService.insert(archives);
             jsonObject.put("msg:","插入成功");
             jsonObject.put("status:",status);
            
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("code:",500);
         }
         return jsonObject;
     }
 }
