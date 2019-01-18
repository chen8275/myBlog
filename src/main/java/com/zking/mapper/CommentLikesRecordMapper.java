package com.zking.mapper;

import com.zking.entity.CommentLikesRecord;

public interface CommentLikesRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentLikesRecord record);

    int insertSelective(CommentLikesRecord record);

    CommentLikesRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentLikesRecord record);

    int updateByPrimaryKey(CommentLikesRecord record);
}