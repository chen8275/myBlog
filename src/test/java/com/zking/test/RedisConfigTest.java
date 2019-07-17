 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.test;

 import com.zking.component.RedisService;
 import com.zking.entity.VO.UserVo;
 import com.zking.util.RedisKeyUtil;
 import lombok.extern.slf4j.Slf4j;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.data.redis.core.*;
 import org.springframework.test.context.junit4.SpringRunner;

 import javax.annotation.Resource;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Set;
 import java.util.concurrent.TimeUnit;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/7/17 14:57
  */
 @SpringBootTest
 @RunWith(SpringRunner.class)
 @Slf4j
 public class RedisConfigTest {
     @Autowired
     private StringRedisTemplate stringRedisTemplate;
    
     @Autowired
     private RedisTemplate redisTemplate;
    
     @Resource
     private ValueOperations<String,Object> valueOperations;
    
     @Autowired
     private HashOperations<String, String, Object> hashOperations;
    
     @Autowired
     private ListOperations<String, Object> listOperations;
    
     @Autowired
     private SetOperations<String, Object> setOperations;
    
     @Autowired
     private ZSetOperations<String, Object> zSetOperations;
    
     @Resource
     private RedisService redisService;
     
     @Test
     public void testObj(){
         UserVo userVo = new UserVo();
         userVo.setAddress("上海");
         userVo.setName("测试dfas");
         userVo.setAge(123);
         ValueOperations<String,Object> operations = redisTemplate.opsForValue();

         redisService.expireKey("name",20, TimeUnit.SECONDS);
         String key = RedisKeyUtil.getKey(UserVo.Table,"name",userVo.getName());
         UserVo vo = (UserVo) operations.get(key);
         System.out.println(vo);
     }
     @Test
     public void testValueOption( ){
         UserVo userVo = new UserVo();
         userVo.setAddress("上海");
         userVo.setName("jantent");
         userVo.setAge(23);
         valueOperations.set("test",userVo);
        
         System.out.println(valueOperations.get("test"));
     }
     
     @Test
     public void testHasKey(){
         if (redisTemplate.hasKey("test")){
             System.out.println("存在");
         }else {
             System.out.println("不存在");
         }
         
     }
     
     @Test
     public void testAddList(){
         List<String> test = new ArrayList<>();
         test.add("1");
         test.add("2");
         test.add("3");
         test.add("4");
        listOperations.rightPush("testList",test);
         System.out.println(listOperations.range("testList",0,-1));

     }
    
    
     @Test
     public void testSetOperation() throws Exception{
         UserVo userVo = new UserVo();
         userVo.setAddress("北京");
         userVo.setName("jantent");
         userVo.setAge(23);
         UserVo auserVo = new UserVo();
         auserVo.setAddress("n柜昂周");
         auserVo.setName("antent");
         auserVo.setAge(23);
         setOperations.add("user:test",userVo,auserVo);
         Set<Object> result = setOperations.members("user:test");
         System.out.println(result);
     }
     @Test
     public void HashOperations() throws Exception{
         UserVo userVo = new UserVo();
         userVo.setAddress("北京");
         userVo.setName("jantent");
         userVo.setAge(23);
         hashOperations.put("hash:user",userVo.hashCode()+"",userVo);
         System.out.println(hashOperations.get("hash:user",userVo.hashCode()+""));
     }
    
     @Test
     public void  ListOperations() throws Exception{
         UserVo userVo = new UserVo();
         userVo.setAddress("北京");
         userVo.setName("jantent");
         userVo.setAge(23);
        listOperations.leftPush("list:user",userVo);
        //System.out.println(listOperations.leftPop("list:user"));
         // pop之后 值会消失
         //System.out.println(listOperations.leftPop("list:user"));
     }
 }
