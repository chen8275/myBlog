package com.zking.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Article {
    
    private Integer id;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
    private Long articleid;

    private String author;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
    private String originalauthor;

    private String articletitle;

    private String articletags;

    private String articletype;

    private String articlecategories;

    private String publishdate;

    private String updatedate;

    private String articleurl;

    private Integer likes;

    private Long lastarticleid;

    private Long nextarticleid;
    
    /**
     * 文章摘要
     */
    private String articletabloid;
    /**
     * 文章内容
     */
    private String articlecontent;
    
    public Article(Integer id, Long articleid, String author, String originalauthor, String articletitle, String articletags, String articletype, String articlecategories, String publishdate, String updatedate, String articleurl, Integer likes, Long lastarticleid, Long nextarticleid, String articletabloid, String articlecontent) {
        this.id = id;
        this.articleid = articleid;
        this.author = author;
        this.originalauthor = originalauthor;
        this.articletitle = articletitle;
        this.articletags = articletags;
        this.articletype = articletype;
        this.articlecategories = articlecategories;
        this.publishdate = publishdate;
        this.updatedate = updatedate;
        this.articleurl = articleurl;
        this.likes = likes;
        this.lastarticleid = lastarticleid;
        this.nextarticleid = nextarticleid;
        this.articletabloid = articletabloid;
        this.articlecontent = articlecontent;
    }
    
    public String getArticletabloid() {
        return articletabloid;
    }
    
    public void setArticletabloid(String articletabloid) {
        this.articletabloid = articletabloid;
    }
    
    public String getArticlecontent() {
        return articlecontent;
    }
    
    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent;
    }
    
    public Article() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getArticleid() {
        return articleid;
    }

    public void setArticleid(Long articleid) {
        this.articleid = articleid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getOriginalauthor() {
        return originalauthor;
    }

    public void setOriginalauthor(String originalauthor) {
        this.originalauthor = originalauthor == null ? null : originalauthor.trim();
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle == null ? null : articletitle.trim();
    }

    public String getArticletags() {
        return articletags;
    }

    public void setArticletags(String articletags) {
        this.articletags = articletags == null ? null : articletags.trim();
    }

    public String getArticletype() {
        return articletype;
    }

    public void setArticletype(String articletype) {
        this.articletype = articletype == null ? null : articletype.trim();
    }

    public String getArticlecategories() {
        return articlecategories;
    }

    public void setArticlecategories(String articlecategories) {
        this.articlecategories = articlecategories == null ? null : articlecategories.trim();
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate == null ? null : publishdate.trim();
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate == null ? null : updatedate.trim();
    }

    public String getArticleurl() {
        return articleurl;
    }

    public void setArticleurl(String articleurl) {
        this.articleurl = articleurl == null ? null : articleurl.trim();
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Long getLastarticleid() {
        return lastarticleid;
    }

    public void setLastarticleid(Long lastarticleid) {
        this.lastarticleid = lastarticleid;
    }

    public Long getNextarticleid() {
        return nextarticleid;
    }

    public void setNextarticleid(Long nextarticleid) {
        this.nextarticleid = nextarticleid;
    }
}