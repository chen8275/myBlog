package com.zking.mapper;

import com.zking.entity.Tags;

public interface TagsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tags record);

    int insertSelective(Tags record);

    Tags selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);
}