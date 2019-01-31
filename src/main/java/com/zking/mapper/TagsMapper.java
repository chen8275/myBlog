package com.zking.mapper;

import com.zking.entity.Tags;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagsMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Tags record);
    int insertSelective(Tags record);
    Tags selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Tags record);
    int updateByPrimaryKey(Tags record);
    
    List<Tags> findTagsCloud();
}