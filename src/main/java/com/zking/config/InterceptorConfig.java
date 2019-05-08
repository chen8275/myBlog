
 package com.zking.config;

 import org.springframework.context.annotation.Configuration;
 import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


 /**
  * 拦截器配置
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/4/22 21:02
  */
 @Configuration
 public class InterceptorConfig extends WebMvcConfigurerAdapter {
     /**
      * excludePathPatterns为不拦截页面可以直接访问
      * @param registry
      */
     @Override
     public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/front/*").excludePathPatterns("/front/login","/front/loginPage","/front/register","/front/index","/front/show","/front/tags","/front/aboutme","/front/categories","/front/update","/front/logout");
         super.addInterceptors(registry);
     }
 }

