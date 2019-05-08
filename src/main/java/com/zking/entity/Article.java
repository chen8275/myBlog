package com.zking.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    
    
}