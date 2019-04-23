 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.zking.service.CommentService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 /**
  * @auther chendesheng
  * @date 2019/1/28
  */
 @RestController
 @RequestMapping(value = "comment")
 public class CommentController {
     
     @Autowired
     CommentService commentService;
    
    
     /**
      * 根据回复id获得用户评论
      * @param answererId
      * @return
      */
     @PostMapping(value = "/getUserComment")
     public ResultModel getUserComment(int answererId){
         try {
             return commentService.getUserComment(answererId);
             
         }catch (Exception e){
             return ResultTools.result(404,e.getMessage(),null);
         }
        
     }
     
     
 }
