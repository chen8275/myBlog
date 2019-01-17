/*
 */
/*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  *//*

 package com.zking.config;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.util.StringUtils;
 import org.springframework.web.servlet.HandlerInterceptor;
 import org.springframework.web.servlet.ModelAndView;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;

 */
/**
  * @auther chendesheng
  * @date 2019/1/10
  *//*

 public class LogCostInterceptor implements HandlerInterceptor {
     private static final Logger log = LoggerFactory.getLogger(LogCostInterceptor.class);
     @Override
     public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
         log.info("---------------------开始进入请求地址拦截----------------------------");
         HttpSession session = httpServletRequest.getSession();
         System.out.println(session.getAttribute("userName"));
         if (!StringUtils.isEmpty(session.getAttribute("userName"))){
             return true;
         }else {
             */
/*PrintWriter printWriter = httpServletResponse.getWriter();
             printWriter.write("{code:0,message:\"session is invalid,please login again!\"}");*//*

             log.info("------:跳转到login页面！");
             System.out.println(httpServletRequest.getContextPath() + "/login");
             httpServletResponse.sendRedirect("/front/login");
             return false;
         }   
     }
    
     @Override
     public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("hello");
     }
    
     @Override
     public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
     }
 }
*/
