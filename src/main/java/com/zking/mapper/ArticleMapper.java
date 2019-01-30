package com.zking.mapper;

import com.zking.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper { 
    
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 插入文章
     * @param record
     * @return 
     */
    int insert(Article record);
    int insertSelective(@Param("article") Article article);
    Article selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Article record);
    int updateByPrimaryKeyWithBLOBs(Article record);
    int updateByPrimaryKey(Article record);
    
    
    
    Article findEndArticleId();
    void insertArticle(Article article);
    void updateArticleLastId(@Param("lastArticleLd") long lastArticleLd, @Param("articleId") long articleId);
    void updateArticleNextId(@Param("nextArticleId") long nextArticleId, @Param("articleId") long articleId);
    void updateArticleById(Article article);
    Article getArticleUrlById(Integer id);
    
    
}