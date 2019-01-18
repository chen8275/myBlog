package com.zking.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name="user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 手机号
     */
    private String phone;
    
    private String username;
    private String password;
    /**
     * 性别
     */
    private String gender;
    /**
     * 真实姓名
     */
    private String trueName;
    
    /**
     * 生日
     */
    private String birthday;
    
    /**
     * 个人简介
     */
    private String personalBrief;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 最后登录时间
     */
    private String recentlyLanded;
    
    /**
     * 头像地址
     */
    private String avatarImgUrl;
    
    
    public User() {
    }
    
    public User(String phone, String username, String password, String gender) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }
    
    public User(String phone, String username, String password, String gender, String trueName, String birthday, String personalBrief, String email, String recentlyLanded, String avatarImgUrl) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.trueName = trueName;
        this.birthday = birthday;
        this.personalBrief = personalBrief;
        this.email = email;
        this.recentlyLanded = recentlyLanded;
        this.avatarImgUrl = avatarImgUrl;
    }
}
