 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;
 

 import com.zking.entity.User;
 import com.zking.mapper.UserMapper;
 import com.zking.service.UserService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.HashMap;
 import java.util.Map;


 /**
  * @auther chendesheng
  * @date 2019/1/10
  */
 @RestController
 @RequestMapping(value = "/user")
 public class UserController {
     @Autowired
     UserService userService;
     @PostMapping("updateUserById")
     public ResultModel updateUser(String username,String phone,String trueName,String birthday,String gender,String email,String personalBrief){
         try {
             User user = new User();
             
             user.setUsername(username);
             user.setPhone(phone);
             user.setTrueName(trueName);
             user.setBirthday(birthday);
             user.setGender(gender);
             user.setPersonalBrief(personalBrief);
             user.setEmail(email);
             int updateNumber = userService.updateByPrimaryKeySelective(user);
             return ResultTools.result(200,"",null);
             
         }catch (Exception e){
             return ResultTools.result(404,e.getMessage(),null);
         }
     }
    /*@GetMapping(value = "/listUsers")
     public ResultModel selectUserByAll(){
        try {
            List<User> users = userMapper.findAll();
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
            User user = userMapper.findUserEntityById(id);
            if (null == user){
                return ResultTools.result(1002,"",null);
            }
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("content", user);
            return ResultTools.result(200,"",map);
        }catch (Exception e){
            return ResultTools.result(404,e.getMessage(),null);
        }
    }*/
    
    
 }
