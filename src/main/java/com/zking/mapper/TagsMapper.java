package com.zking.mapper;

import com.zking.entity.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagsMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteByTagsName(String tagsName);
    
    int insert(Tags record);
    int findIsExitByTagName(String tagName);
    
    int insertSelective(Tags record);
    Tags selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Tags record);
    int updateByPrimaryKey(Tags record);
    
    List<Tags> findTagsCloud();
}