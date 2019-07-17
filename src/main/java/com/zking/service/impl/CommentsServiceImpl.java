 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.alibaba.fastjson.JSON;
 import com.zking.entity.Comments;
 import com.zking.entity.CommentsExample;
 import com.zking.mapper.CommentsMapper;
 import com.zking.service.CommentsService;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/7/17 10:13
  */
 @Service
 @Slf4j
 public class CommentsServiceImpl implements CommentsService {
     @Autowired
     CommentsMapper commentsMapper;
     
     @Override
     public List<Comments> commentsList() {
         CommentsExample example = new CommentsExample();
         CommentsExample.Criteria criteria= example.createCriteria();
         criteria.andUsernameEqualTo("xuxu");
         List<Comments> comments = commentsMapper.selectByExample(example);
         log.info("得到:{}",JSON.toJSONString(comments));
         return comments;
     }
 }
