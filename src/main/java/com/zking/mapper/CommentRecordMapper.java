package com.zking.mapper;

import com.zking.entity.CommentRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRecordMapper {
    int deleteByPrimaryKey(Long id);
    int insert(CommentRecord record);
    int insertSelective(CommentRecord record);
    CommentRecord selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(CommentRecord record);
    int updateByPrimaryKeyWithBLOBs(CommentRecord record);
    int updateByPrimaryKey(CommentRecord record);
    
    List<CommentRecord> getUserComment(int answererId);
}