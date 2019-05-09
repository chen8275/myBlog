 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;

 import lombok.extern.slf4j.Slf4j;
 import org.springframework.web.bind.annotation.*;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.util.HashMap;
 import java.util.Map;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/5/9 20:51
  */
 @RestController
 @Slf4j
 public class LearnController {
     
     @GetMapping(value = "/hello")
     @ResponseBody
     public Map<String,Object> login(){
         //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
         log.trace("日志输出 trace");
         log.debug("日志输出 debug");
         log.info("日志输出 info");
         log.warn("日志输出 warn");
         log.error("日志输出 error");
         Map<String,Object> map =new HashMap<String,Object>();
         map.put("result","1");
         return map;
     }
 }
