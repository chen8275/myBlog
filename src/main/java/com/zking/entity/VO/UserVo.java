 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.entity.VO;

 import lombok.Data;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/7/17 14:57
  */
 @Data
 public class UserVo {
     
     public  static final String Table = "t_user";
    
     private String name;
     private String address;
     private Integer age;
 }
