package com.zking.dao;

import com.zking.entity.Fish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FishMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fish record);

    int insertSelective(Fish record);

    Fish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fish record);

    int updateByPrimaryKey(Fish record);
    
    List<Fish> selectFish(@Param("name") String name, @Param("publishName") String publishName, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize); 
        
    List<Fish> listFish(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    
    int countFish();
    
    int updateStatement(@Param("name") String name, @Param("id") Integer id);
}