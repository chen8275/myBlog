package com.zking.mapper;

import com.zking.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */

@Repository
public interface UserMapper extends CrudRepository<User,Long>{

    public User findByUsernameAndPassword(String username, String password);
    @Override
    public List<User> findAll();
    public User findUserEntityById(Long id);
    
}
