package com.zking.mapper;

import com.zking.entity.Archives;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArchivesMapper {
    
    int deleteByPrimaryKey(Integer id);
    int insert(Archives record);
    int insertSelective(Archives record);
    Archives selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Archives record);
    int updateByPrimaryKey(Archives record);
    
    int findArchiveNameByArchiveName(@Param("archiveName") String archiveName);
    void addArchiveName(@Param("archiveName") String archiveName);
}