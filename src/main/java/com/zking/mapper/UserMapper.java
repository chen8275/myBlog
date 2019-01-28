package com.zking.mapper;

import com.zking.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKey(User record);
    
    
    
    
    User selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    
    int findUserIdByUsername(String username);
    
    int updateByPrimaryKeySelective(User user);
    
    int savePersonalDate();
    
    User findUsernameByUsername(String username);
    
    int savePersonalDate(@Param("user") User user, @Param("username") String username);
    
    User getUserPersonalInfo(String username);
}