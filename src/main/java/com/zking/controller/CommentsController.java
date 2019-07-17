 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import com.zking.entity.Comments;
 import com.zking.service.CommentsService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import java.util.List;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/7/17 10:22
  */
 @RestController
 @RequestMapping("/comments")
 public class CommentsController {
     @Autowired
     CommentsService commentsService;
     
     @PostMapping("/commentsList")
     public List<Comments> commentsList(String name){
         List<Comments> list = commentsService.commentsList(name);
         return list;
     }
     
     @PostMapping("/comments")
     public Comments comments(String id){
         Comments comments = commentsService.select(id);
         return comments;
     }
     
 }
