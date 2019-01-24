package com.zking.mapper;

import com.zking.entity.PrivateWord;
import org.apache.ibatis.annotations.Mapper;

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
}