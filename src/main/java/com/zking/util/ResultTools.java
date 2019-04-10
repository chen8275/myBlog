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
 public class ResultTools {
     
     
     public static ResultModel result(int Errcode, String Errmsg, Map<String,Object> map){
        
         ResultModel model = new ResultModel();
         model.setErrcode(Errcode);
         switch (Errcode){
             case 200:
                 model.setErrmeg("成功");
                 if (map!= null){
                     model.setData(map);
                 }
                 break;
             case 1001:
                 model.setErrmeg("请求传参错误");
                 break;
             case 1002:
                 model.setErrmeg("没有对应内容");
                 break;
             case 1003:
                 model.setErrmeg("此用户已存在");
                 break;
             case 1004:
                 model.setErrmeg("上传文件为空");
                 break;
             case 404:
                 model.setErrmeg(Errmsg);
                 break;
             default:
                 model.setErrmeg("未知错误");
                 break;
         }
         return model;
     }
 }
