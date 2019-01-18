package com.zking.mapper;

import com.zking.entity.CommentRecord;

public interface CommentRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentRecord record);

    int insertSelective(CommentRecord record);

    CommentRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentRecord record);

    int updateByPrimaryKeyWithBLOBs(CommentRecord record);

    int updateByPrimaryKey(CommentRecord record);
}