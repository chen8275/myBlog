 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import javax.servlet.http.HttpSession;
 import java.util.UUID;

 /**
  * 测试共享session
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/4/23 16:39
  */
 @RestController
 @RequestMapping("/session")
 public class sessionController {
     
     @PostMapping("/uid")
     String uid(HttpSession session) {
         UUID uid = (UUID) session.getAttribute("uid");
         if (uid == null) {
             uid = UUID.randomUUID();
         }
         session.setAttribute("uid", uid);
         return session.getId();
     }
     
 }
