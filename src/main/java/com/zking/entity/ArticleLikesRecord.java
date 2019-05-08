package com.zking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleLikesRecord {
    
    private Integer id;

    private Long articleid;

    private String originalauthor;

    private Integer likerid;

    private String likedate;

   
}