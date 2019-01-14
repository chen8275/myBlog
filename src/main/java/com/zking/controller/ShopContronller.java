 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.controller;
 
 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Shop;
 import com.zking.service.ShopService;
 import com.zking.util.ResultModel;
 import com.zking.util.ResultTools;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2018/10/31
  */
 @RestController
 @RequestMapping("/shop")
 public class ShopContronller {
     @Autowired
     ShopService shopService;
     
     @RequestMapping("/insert")
     public JSONObject insertShop(HttpServletRequest request, HttpServletResponse response){
         int id = Integer.valueOf(request.getParameter("id"));
         String name = request.getParameter("name");
         String location = request.getParameter("location");
         
         JSONObject jsonObject = new JSONObject();
         Shop shop = new Shop();
         shop.setId(id);
         shop.setName(name);
         shop.setLocation(location);
         int shopNumber = 0;
         try {
             shopNumber = shopService.insertShop(shop);
         }catch (Exception e){
             e.printStackTrace();
         }
         if(shopNumber == -1){
             
             jsonObject.put("msgcode:","插入失败");
             jsonObject.put("fishNumber:",shopNumber+"");
         }else{
             jsonObject.put("msgcode:","插入成功");
             jsonObject.put("fishNumber:",shopNumber+"");
         }
         return jsonObject;
     }
     

     @RequestMapping("getAll")
     public ResultModel getAll(int pageNum, int pageSize){
         try {
             List<Shop> list = shopService.listAllShop(pageNum*(pageSize-1),pageSize);
             Map<String,Object> map = new HashMap<String,Object>();
             map.put("content",list);
             return ResultTools.result(200,"",map);
             
         }catch (Exception e){
             return ResultTools.result(404,e.getMessage(),null);
         }
     }
     
    
     @RequestMapping("updateById")
     public ResultModel update(String name,int id){
         try {
             int updateNum = shopService.updateShopById(name,id);
             return ResultTools.result(200,"",null);
         }catch (Exception e){
             return ResultTools.result(404,e.getMessage(),null);
         }
     }
     
     @RequestMapping("/delete")
     public JSONObject deleteShop(int id){
         JSONObject jsonObject = new JSONObject();
         try {
             int num = shopService.deleteShopById(id);
             jsonObject.put("msgcode",200);
             jsonObject.put("msg","删除成功");
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("msgcode","删除失败");
         }
         return jsonObject;
     }
     
     @RequestMapping("/selectByLocation")
     public ResultModel selectByLocation(String location,int pageNum, int pageSize){
        try {
            List<Shop> list = shopService.listAllShopByLocation(location,pageNum,pageSize);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("content",list);
            return ResultTools.result(200,"",map);
        }catch (Exception e){
            return ResultTools.result(404,"",null);
        }
     }
     
 }
