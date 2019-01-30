 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.zking.service.impl;

 import com.alibaba.fastjson.JSONObject;
 import com.zking.entity.Article;
 import com.zking.mapper.ArticleMapper;
 import com.zking.service.ArchiveService;
 import com.zking.service.ArticleService;
 import com.zking.util.TimeUtil;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;



 /**
  * @auther chendesheng
  * @date 2019/1/29
  */
 @Service
 public class ArticleServiceImpl implements ArticleService {
     
     private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
     @Autowired
     ArticleMapper articleMapper;
     @Autowired
     ArchiveService archiveService;
     @Autowired
     ArticleService articleService;
    
     
     @Override
     public int insert(Article article) {
         
         return  articleMapper.insertSelective(article);
     }
    
     
     
     @Override
     public JSONObject insertArticle(Article article) {
         JSONObject articleReturn = new JSONObject();
         try {
             if ("".equals(article.getOriginalauthor())){
                 article.setOriginalauthor(article.getAuthor());
             }
             if ("".equals(article.getArticleurl())){
                 String url = "https://www.zhyocean.cn/findArticle?articleId=" + article.getArticleid() + "&originalAuthor=" + article.getOriginalauthor();
                 article.setArticleurl(url);
             }
             Article endArticleId = articleMapper.findEndArticleId();
             //设置文章的上一篇文章id
             if (endArticleId != null){
                 article.setLastarticleid(endArticleId.getArticleid());
             }
             articleMapper.insertArticle(article);
            
             //判断发表文章的归档日期是否存在，不存在则插入归档日期
             TimeUtil timeUtil = new TimeUtil();
             String archiveName = timeUtil.timeWhippletreeToYear(article.getPublishdate().substring(0, 7));
             archiveService.addArchiveName(archiveName);
             //设置上一篇文章的下一篇文章id
             if(endArticleId != null){
                 articleService.updateArticleLastOrNextId("nextArticleId", article.getArticleid(), endArticleId.getArticleid());
             }
             
             articleReturn.put("status",200);
             articleReturn.put("articleTitle",article.getArticletitle());
             articleReturn.put("updateDate",article.getUpdatedate());
             articleReturn.put("author",article.getOriginalauthor());
             //本博客中的URL
             articleReturn.put("articleUrl","/findArticle?articleId=" + article.getArticleid() + "&originalAuthor=" + article.getOriginalauthor());
             return articleReturn;
             
         }catch (Exception e){
             articleReturn.put("status",500);
             logger.error("用户 " + article.getAuthor() + " 保存文章 " + article.getArticletitle() + " 失败");
             e.printStackTrace();
             return articleReturn;
         }
         
     }
    
     
     
     @Override
     public void updateArticleLastOrNextId(String lastOrNext, long lastOrNextArticleId, long articleId) {
         
         if("lastArticleId".equals(lastOrNext)){
             articleMapper.updateArticleLastId(lastOrNextArticleId, articleId);
         }
         if("nextArticleId".equals(lastOrNext)){
             articleMapper.updateArticleNextId(lastOrNextArticleId, articleId);
         }
     }
    
     @Override
     public JSONObject updateArticleById(Article article) {
         Article a = articleMapper.getArticleUrlById(article.getId());
         if("原创".equals(article.getArticletype())){
             article.setOriginalauthor(article.getAuthor());
             String url = "https://www.zhyocean.cn/findArticle?articleId=" + a.getArticleid() + "&originalAuthor=" + a.getOriginalauthor();
             article.setArticleurl(url);
         }
         articleMapper.updateArticleById(article);
         JSONObject articleReturn = new JSONObject();
         articleReturn.put("status",200);
         articleReturn.put("articleTitle",article.getArticletitle());
         articleReturn.put("updateDate",article.getUpdatedate());
         articleReturn.put("author",article.getOriginalauthor());
         //本博客中的URL
         articleReturn.put("articleUrl","/findArticle?articleId=" + a.getArticleid() + "&originalAuthor=" + a.getOriginalauthor());
         return articleReturn;
     }
 }
