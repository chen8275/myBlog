/*

 package com.zking.config;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.web.servlet.HandlerInterceptor;
 import org.springframework.web.servlet.ModelAndView;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import java.io.PrintWriter;


 */
/**
  * @auther chendesheng
  * @date 2019/1/10
  *//*

 @Configuration
 public class LogCostInterceptor implements HandlerInterceptor {
     private static final Logger log = LoggerFactory.getLogger(LogCostInterceptor.class);
     @Override
     public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
         log.info("---------------------开始进入请求地址拦截----------------------------");
         HttpSession session = httpServletRequest.getSession();
         System.out.println(session.getAttribute("userName"));
         if (session.getAttribute("userName")!=null){
             return true;
         }else{
            
             PrintWriter printWriter = httpServletResponse.getWriter();
             printWriter.write("{code:0,message:\"session is invalid,please login again!\"}");

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
