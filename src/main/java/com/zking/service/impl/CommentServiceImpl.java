 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.zking.entity.CommentRecord;
 import com.zking.entity.LeaveMessageRecord;
 import com.zking.mapper.CommentRecordMapper;
 import com.zking.service.CommentService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.HashMap;
 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2019/1/28
  */
 @Service
 public class CommentServiceImpl implements CommentService {
     
     @Autowired
     CommentRecordMapper commentRecordMapper;
     @Override
     public ResultModel getUserComment(int answererId) {
         
         List<CommentRecord> commentRecords = commentRecordMapper.getUserComment(answererId);
         HashMap<String,Object> map = new HashMap<>();
         map.put("content:",commentRecords);
         return ResultTools.result(200,"",map);
         
     }
 }
