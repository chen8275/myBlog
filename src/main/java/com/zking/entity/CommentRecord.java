package com.zking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRecord {
    
    private Long id;

    private Long pid;

    private Long articleid;

    private String originalauthor;

    private Integer answererid;

    private Integer respondentid;

    private String commentdate;

    private Integer likes;

    private String commentcontent;

    
}