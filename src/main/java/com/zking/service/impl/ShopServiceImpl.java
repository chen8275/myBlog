 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;


import com.zking.dao.ShopMapper;
import com.zking.entity.Shop;
import com.zking.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/10/31
  */
 @Service
 public class ShopServiceImpl implements ShopService {
    
     @Autowired
     ShopMapper shopMapper;
     
     @Override
     public int insertShop(Shop shop) {
         return shopMapper.insert(shop);
     }
    
     @Override
     public List<Shop> listAllShop(int pageNum, int pageSize) {
         return shopMapper.listShop(pageNum,pageSize);
     }
    
     @Override
     public int updateShopById(String name,int id) {
         return shopMapper.updateById(name,id);
     }
    
     @Override
     public int deleteShopById(int id) {
         return shopMapper.deleteById(id);
     }
    
     @Override
     public List<Shop> listAllShopByLocation(String location, int pageNum, int pageSize) {
         return shopMapper.selectByLocation(location,pageNum,pageSize);
     }
    
 }
