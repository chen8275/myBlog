package com.zking.mapper;

import com.zking.entity.PrivateWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrivatewordMapper {
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 插入悄悄话
     */
    int insert(PrivateWord record);
    
    int insertSelective(PrivateWord record);
    PrivateWord selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(PrivateWord record);
    int updateByPrimaryKey(PrivateWord record);
    /**
     * 获得所有悄悄话
     */
    List<PrivateWord> getAllPrivateWord();
        

}