package com.zking.mapper;

import com.zking.entity.LeaveMessageRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LeaveMessageRecordMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(LeaveMessageRecord record);
    int insertSelective(LeaveMessageRecord record);
    LeaveMessageRecord selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(LeaveMessageRecord record);
    int updateByPrimaryKeyWithBLOBs(LeaveMessageRecord record);
    int updateByPrimaryKey(LeaveMessageRecord record);
    
    
    List<LeaveMessageRecord> getUserLeaveMessage(int answererId);
}