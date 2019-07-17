 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.util;

 /**
  *  redisKey设计
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/7/17 14:55
  */
 public class RedisKeyUtil {
     /**
      * redis的key
      * 形式为：
      * 表名:主键名:主键值:列名
      *
      * @param tableName 表名
      * @param majorKey 主键名
      * @param majorKeyValue 主键值
      * @param column 列名
      * @return
      */
     public static String getKeyWithColumn(String tableName,String majorKey,String majorKeyValue,String column){
         StringBuffer buffer = new StringBuffer();
         buffer.append(tableName).append(":");
         buffer.append(majorKey).append(":");
         buffer.append(majorKeyValue).append(":");
         buffer.append(column);
         return buffer.toString();
     }
     /**
      * redis的key
      * 形式为：
      * 表名:主键名:主键值
      *
      * @param tableName 表名
      * @param majorKey 主键名
      * @param majorKeyValue 主键值
      * @return
      */
     public static String getKey(String tableName,String majorKey,String majorKeyValue){
         StringBuffer buffer = new StringBuffer();
         buffer.append(tableName).append(":");
         buffer.append(majorKey).append(":");
         buffer.append(majorKeyValue).append(":");
         return buffer.toString();
     }
 }
