package com.zking.mapper;

import com.zking.entity.userRole;

public interface userRoleMapper {
    int insert(userRole record);

    int insertSelective(userRole record);
}