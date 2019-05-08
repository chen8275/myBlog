package com.zking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback {
    
    private Integer id;

    private String contactinfo;

    private Integer personid;

    private String feedbackdate;

    private String feedbackcontent;

    
}