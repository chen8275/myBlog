 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/5/9 9:41
  */
 @RestController
 @RequestMapping("/front")
 public class DockerController {
     
     @RequestMapping("/index")
     public String index() {
         return "Hello Docker!";
     }
     
 }
