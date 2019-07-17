package com.zking.service.impl;


import com.alibaba.fastjson.JSON;
import com.zking.config.RedisConfig;
import com.zking.entity.Book;
import com.zking.entity.User;
import com.zking.service.RedisTemplateService;
import com.zking.service.TagService;
import com.zking.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author chendesheng chendesheng@tuhu.cn
 * @since 2019/7/16 17:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TagServiceImplTest {
    @Autowired
    TagService tagService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplateService redisTemplateService;
    @Autowired
    RedisTemplate MyRedisTemplate;
    
    
    @Test
    public void findTagsCloud() {
        Book book = new Book();
        book.setName("三国演义");
        book.setNum(4);
        book.setPublishName("chanjiang");
        MyRedisTemplate.opsForValue().set(book.getName(),book); 
        
        log.info("得到的书籍为：{}",MyRedisTemplate.opsForValue().get(book.getName()));
    }   
    
    
    @Test
    public void redisTest(){
        User user = new User();
        user.setId(11);
        user.setUsername("test");
        user.setPassword("hello redis");
        redisTemplateService.set("key1",user);
    
        log.info("dedao:{}",redisTemplateService.get("key1",User.class));

    
    }}
    
    
    