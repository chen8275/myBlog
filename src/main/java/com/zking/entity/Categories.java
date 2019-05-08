package com.zking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categories {
    
    private Integer id;

    private String categoryname;
    
    private String displayname;
    
    
}