 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service;



 import com.zking.entity.Fish;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/24
  */
 public interface FishService {
     
     List<Fish> listAllFish(int pageNum, int pageSize);
     
     int insertFish(Fish fish);
     
     int count();
     
     int updateFishById(String name, Integer id);
     
     List<Fish> select(String name, String publishName, int pageIndex, int pageSize);
 }
