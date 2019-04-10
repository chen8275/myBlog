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
 import com.zking.entity.PrivateWord;
 import com.zking.mapper.PrivatewordMapper;
 import com.zking.service.PrivateWordService;
 import com.zking.service.UserService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.codehaus.groovy.runtime.RangeInfo;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.text.SimpleDateFormat;
 import java.util.*;

 /**
  * @auther chendesheng
  * @date 2019/1/24
  */
 @Service
 public class PrivateWordServiceImpl implements PrivateWordService {
     @Autowired
     UserService userService;
     @Autowired
     PrivatewordMapper privatewordMapper;
     
     @Override
     public ResultModel publishPrivateWord(String privateWordContent, String username) {
         
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
         String publisherDate = sdf.format(new Date());
         
         int userId = userService.findUserIdByUsername(username);
         PrivateWord privateWord = new PrivateWord(privateWordContent,userId,publisherDate);
         int status = privatewordMapper.insert(privateWord);
         Map<String,Object> map = new HashMap<String,Object>();
         map.put("content",status);
         return ResultTools.result(200,"",map);
        
     }
    
     @Override
     public JSONObject getAllPrivateWord() {
         
         List<PrivateWord> privateWords = privatewordMapper.getAllPrivateWord();
    
         JSONObject returnJson = new JSONObject();
         JSONObject userJson;
         JSONArray allJsonArray = new JSONArray();
         JSONObject newUserJson;
    
         returnJson.put("status",200);
         List<String> publishers = new ArrayList<>();
         
         String publisher;
         for(PrivateWord privateWord : privateWords){
             userJson = new JSONObject();
             userJson.put("privateWord", privateWord.getPrivateword());
             publisher = userService.findUsernameById(privateWord.getPublisherid());
             userJson.put("publisher", publisher);
             userJson.put("publisherDate", privateWord.getPublisherdate());
             userJson.put("id", privateWord.getId());
             if(privateWord.getReplycontent() == null){
                 userJson.put("replier","");
                 userJson.put("replyContent","");
             } else {
                 userJson.put("replyContent",privateWord.getReplycontent());
                 userJson.put("replier",userService.findUsernameById(privateWord.getReplierid()));
             }
             if(!publishers.contains(publisher)){
                 publishers.add(publisher);
                 newUserJson = new JSONObject();
                 newUserJson.put("publisher",publisher);
                 newUserJson.put("content",new JSONArray());
                 allJsonArray.add(newUserJson);
             }
             for(int i=0;i<allJsonArray.size();i++){
                 JSONObject arrayUser = (JSONObject) allJsonArray.get(i);
                 if(arrayUser.get("publisher").equals(publisher)){
                     JSONArray jsonArray = (JSONArray) arrayUser.get("content");
                     jsonArray.add(userJson);
                     arrayUser.put("publisher", publisher);
                     arrayUser.put("content", jsonArray);
                     allJsonArray.remove(i);
                
                     allJsonArray.add(arrayUser);
                     break;
                 }
             }
         }
         returnJson.put("result",allJsonArray);
         System.out.println("getAllPrivateWord result is " + returnJson);
         return returnJson;
     }
    
     @Override
     public JSONObject replyPrivateWord(String replyContent, String username, int id) {
         JSONObject returnJson = new JSONObject();
         privatewordMapper.replyPrivateWord(replyContent, userService.findIdByUsername(username), id);
         
         returnJson.put("status",200);
         JSONObject replyJson = new JSONObject();
         replyJson.put("replyContent",replyContent);
         replyJson.put("replierId",id);
         returnJson.put("result",replyJson);
         return returnJson;
     }
 }
