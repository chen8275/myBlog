package com.zking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveMessageLikesRecord {
    
    private Integer id;

    private String pagename;

    private Integer pid;

    private Integer likerid;

    private String likedate;

    
}