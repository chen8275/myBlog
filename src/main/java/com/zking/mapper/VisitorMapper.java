package com.zking.mapper;

import com.zking.entity.Visitor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitorMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Visitor record);
    int insertSelective(Visitor record);
    Visitor selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Visitor record);
    int updateByPrimaryKeyWithBLOBs(Visitor record);
    int updateByPrimaryKey(Visitor record);
    
    long getAllVisitor();
}