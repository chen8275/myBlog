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
public class PrivateWord extends JdkSerializationRedisSerializer implements Serializable {
    private int id;
    
    /**
     * 悄悄话内容
     */
    private String privateword;
    
    /**
     * 发布者
     */
    private int publisherid;
    
    /**
     * 回复者
     */
    private int  replierid;
    
    /**
     * 回复内容
     */
    private String replycontent;
    
    /**
     * 发布时间
     */
    private String publisherdate;
    
    
    public PrivateWord(String privateword, int publisherid, String publisherdate) {
        this.privateword = privateword;
        this.publisherid = publisherid;
        this.publisherdate = publisherdate;
    }
    
}