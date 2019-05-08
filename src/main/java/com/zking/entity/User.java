package com.zking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends JdkSerializationRedisSerializer implements Serializable {
    
    private Integer id;

    private String avatarImgUrl;

    private String birthday;

    private String email;

    private String gender;

    private String password;

    private String personalBrief;

    private String phone;

    private String recentlyLanded;

    private String trueName;

    private String username;
    
    private List<Role> roles;
    
}