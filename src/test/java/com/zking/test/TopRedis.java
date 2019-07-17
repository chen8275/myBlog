 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.test;

 import com.alibaba.fastjson.JSON;
 import lombok.extern.slf4j.Slf4j;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.data.redis.core.DefaultTypedTuple;
 import org.springframework.data.redis.core.StringRedisTemplate;
 import org.springframework.data.redis.core.ZSetOperations;
 import org.springframework.test.context.junit4.SpringRunner;

 import java.util.HashSet;
 import java.util.Set;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/7/17 15:26
  */
 @SpringBootTest
 @RunWith(SpringRunner.class)
 @Slf4j
 public class TopRedis {
     @Autowired
     private StringRedisTemplate redisTemplate;
    
     public static final String SCORE_RANK = "score_rank";
    
     /**
      * 批量新增
      */
     @Test
     public void batchAdd() {
         Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();
         long start = System.currentTimeMillis();
         for (int i = 0; i < 100000; i++) {
             DefaultTypedTuple<String> tuple = new DefaultTypedTuple<>("张三" + i, 1D + i);
             tuples.add(tuple);
         }
         System.out.println("循环时间:" +( System.currentTimeMillis() - start));
         Long num = redisTemplate.opsForZSet().add(SCORE_RANK, tuples);
         System.out.println("批量新增时间:" +(System.currentTimeMillis() - start));
         System.out.println("受影响行数：" + num);
     }
     /**
      * 获取排行列表
      */
     @Test
     public void list() {
        
         Set<String> range = redisTemplate.opsForZSet().reverseRange(SCORE_RANK, 0, 10);
         System.out.println("获取到的排行列表:" + JSON.toJSONString(range));
         Set<ZSetOperations.TypedTuple<String>> rangeWithScores = redisTemplate.opsForZSet().reverseRangeWithScores(SCORE_RANK, 0, 10);
         System.out.println("获取到的排行和分数列表:" + JSON.toJSONString(rangeWithScores));
     }
     /**
      * 单个新增
      */
     @Test
     public void add() {
         redisTemplate.opsForZSet().add(SCORE_RANK, "李四", 8899);
     }
     /**
      * 获取单个的排行
      */
     @Test
     public void find(){
         Long rankNum = redisTemplate.opsForZSet().reverseRank(SCORE_RANK, "李四");
         System.out.println("李四的个人排名：" + rankNum);
        
         Double score = redisTemplate.opsForZSet().score(SCORE_RANK, "李四");
         System.out.println("李四的分数:" + score);
     }
     /**
      * 统计两个分数之间的人数
      */
     @Test
     public void count(){
         Long count = redisTemplate.opsForZSet().count(SCORE_RANK, 8001, 9000);
         System.out.println("统计8001-9000之间的人数:" + count);
     }
     /**
      * 获取整个集合的基数(数量大小)
      */
     @Test
     public void zCard(){
         Long aLong = redisTemplate.opsForZSet().zCard(SCORE_RANK);
         System.out.println("集合的基数为：" + aLong);
     }
     /**
      * 使用加法操作分数
      */
     @Test
     public void incrementScore(){
         Double score = redisTemplate.opsForZSet().incrementScore(SCORE_RANK, "李四", 1000);
         System.out.println("李四分数+1000后：" + score);
     }
 }
