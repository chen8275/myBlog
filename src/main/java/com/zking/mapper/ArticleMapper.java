package com.zking.mapper;

import com.zking.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper { 
    
    int deleteByPrimaryKey(Integer id);
    int deleteByCategoryName(String categoryName);
    int countByCategoryName(String categoryName);
    int countByTags(String tagsName);
    
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
    List<Article> findArticleByCategory(String category);
    List<Article> findAllArticlesPartInfo();
    List<Article> listArticles();

    
    int countArticleCategoryByCategory(@Param("category") String category);
    List<Article> findArticleByTag(@Param("tag") String tag);
    int countArticle();
    
    List<Article> getArticleManagement();
    
    
    
}