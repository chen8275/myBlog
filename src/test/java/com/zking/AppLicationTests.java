 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking;

 import org.junit.After;
 import org.junit.Before;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.test.context.junit4.SpringRunner;
 import org.springframework.test.context.web.WebAppConfiguration;

 /**
  * @auther chendesheng
  * @date 2019/1/28
  */
 @RunWith(SpringRunner.class)
 @SpringBootTest
 @WebAppConfiguration
 public class AppLicationTests {
     
     @Before    
     public void init() {        
         System.out.println("开始测试-----------------");    
     }     
     @After    
     public void after() {        
         System.out.println("测试结束-----------------");    
     }
     
 }
