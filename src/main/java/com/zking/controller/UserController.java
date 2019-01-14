 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;
 

 import com.zking.dao.UserDao;
 import com.zking.entity.UserEntity;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2019/1/10
  */
 @RestController
 @RequestMapping(value = "/user")
 public class UserController {
     
     @Autowired
     private UserDao userDao;
     
    @GetMapping(value = "/listUsers")
     public ResultModel selectUserByAll(){
        try {
            List<UserEntity> users = userDao.findAll();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("content",users);
            return ResultTools.result(200,"",map);
        }catch (Exception e){
            return ResultTools.result(404,e.getMessage(),null);
        }
    }
    @PostMapping(value = "/selectUserById")
     public ResultModel selectUserById(Long id){
        try {
            if (null == id){
                return ResultTools.result(1001,"",null);
            }
            UserEntity userEntity = userDao.findUserEntityById(id);
            if (null == userEntity){
                return ResultTools.result(1002,"",null);
            }
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("content",userEntity);
            return ResultTools.result(200,"",map);
        }catch (Exception e){
            return ResultTools.result(404,e.getMessage(),null);
        }
    }
    
 }
