package com.zking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback extends JdkSerializationRedisSerializer implements Serializable {
    
    private Integer id;

    private String contactinfo;

    private Integer personid;

    private String feedbackdate;

    private String feedbackcontent;

    
}