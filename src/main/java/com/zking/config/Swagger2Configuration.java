 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.config;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.Profile;
 import springfox.documentation.builders.ApiInfoBuilder;
 import springfox.documentation.builders.PathSelectors;
 import springfox.documentation.builders.RequestHandlerSelectors;
 import springfox.documentation.service.ApiInfo;
 import springfox.documentation.spi.DocumentationType;
 import springfox.documentation.spring.web.plugins.Docket;
 import springfox.documentation.swagger2.annotations.EnableSwagger2;

 /**
  * @author chendesheng
  * @date: 2019/2/28 20:36
  */
 
 @Configuration
 @EnableSwagger2
 public class Swagger2Configuration {
     
     @Bean
     public Docket createRestApi() {
         return new Docket(DocumentationType.SWAGGER_2)
                 .apiInfo(apiInfo())
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.zking.controller"))
                 .paths(PathSelectors.any())
                 .build();
     }
    
     private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                 .title("博客系统")
                 .description("")
                 .termsOfServiceUrl("")
                 .contact("")
                 .version("1.0.0")
                 .build();
     }
 }
