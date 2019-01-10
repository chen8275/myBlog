 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.util;

 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2019/1/10
  */
 public class ResultModel {
     
     private int errcode;// 返回码
     private String errmeg;// 返回消息
     private Map<String, Object> data;// 数据源
    
     public int getErrcode() {
         return errcode;
     }
    
     public void setErrcode(int errcode) {
         this.errcode = errcode;
     }
    
     public String getErrmeg() {
         return errmeg;
     }
    
     public void setErrmeg(String errmeg) {
         this.errmeg = errmeg;
     }
    
     public Map<String, Object> getData() {
         return data;
     }
    
     public void setData(Map<String, Object> data) {
         this.data = data;
     }
 }
