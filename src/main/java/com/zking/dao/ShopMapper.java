package com.zking.dao;


import com.zking.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopMapper {
    int insert(Shop record);
    int insertSelective(Shop record);
    List<Shop> listShop(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    int updateById(@Param("name") String name, @Param("id") int id);
    int deleteById(@Param("id") int id);
    List<Shop> selectByLocation(@Param("location") String location,@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}