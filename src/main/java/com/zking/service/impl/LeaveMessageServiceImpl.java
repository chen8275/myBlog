 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;
 import com.alibaba.fastjson.JSONArray;
 import com.alibaba.fastjson.JSONObject;
 import com.github.pagehelper.PageHelper;
 import com.github.pagehelper.PageInfo;
 import com.zking.constant.SiteOwner;
 import com.zking.entity.LeaveMessageRecord;
 import com.zking.mapper.LeaveMessageRecordMapper;
 import com.zking.service.LeaveMessageService;
 import com.zking.service.UserService;
 import com.zking.util.TimeUtil;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.HashMap;
 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2019/1/28
  */
 @Service
 public class LeaveMessageServiceImpl implements LeaveMessageService {
     
     @Autowired
     LeaveMessageRecordMapper leaveMessageRecordMapper;
     @Autowired
     UserService userService;
    
    
     @Override
     public int insertLeaveMessage(String leaveMessageContent, String pageName, String answerer) {
         
         TimeUtil timeUtil = new TimeUtil();
         String nowStr = timeUtil.getFormatDateForFive();
         LeaveMessageRecord leaveMessage = new LeaveMessageRecord(pageName, userService.findIdByUsername(answerer), userService.findIdByUsername(SiteOwner.SITE_OWNER), nowStr, leaveMessageContent);
         
         return leaveMessageRecordMapper.insertLeaveMessage(leaveMessage);
     }
 }
