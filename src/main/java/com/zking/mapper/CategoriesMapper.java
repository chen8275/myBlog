package com.zking.mapper;

import com.zking.entity.Categories;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoriesMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Categories record);
    int insertSelective(Categories record);
    Categories selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Categories record);
    int updateByPrimaryKey(Categories record);
    
    List<Categories> listCategories();
    List<String> findCategoriesName();
    
    
}