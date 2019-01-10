package com.zking.dao;

import com.zking.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */

@Repository
public interface UserDao extends CrudRepository<UserEntity,Long>{

    public UserEntity findByUsernameAndPassword(String username,String password);
    @Override
    public List<UserEntity> findAll();
    public UserEntity findUserEntityById(Long id);
  
    
}
