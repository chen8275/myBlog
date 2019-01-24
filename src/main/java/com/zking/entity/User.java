package com.zking.entity;

public class User {
    
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
    
    public User(Integer id, String avatarImgUrl, String birthday, String email, String gender, String password, String personalBrief, String phone, String recentlyLanded, String trueName, String username) {
        this.id = id;
        this.avatarImgUrl = avatarImgUrl;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.personalBrief = personalBrief;
        this.phone = phone;
        this.recentlyLanded = recentlyLanded;
        this.trueName = trueName;
        this.username = username;
    }
    
    public User() {
        super();
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getAvatarImgUrl() {
        return avatarImgUrl;
    }

    public void setAvatarImgUrl(String avatarImgUrl) {
        this.avatarImgUrl = avatarImgUrl == null ? null : avatarImgUrl.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPersonalBrief() {
        return personalBrief;
    }

    public void setPersonalBrief(String personalBrief) {
        this.personalBrief = personalBrief == null ? null : personalBrief.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRecentlyLanded() {
        return recentlyLanded;
    }

    public void setRecentlyLanded(String recentlyLanded) {
        this.recentlyLanded = recentlyLanded == null ? null : recentlyLanded.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}