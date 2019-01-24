package com.zking.entity;


public class PrivateWord {
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
    
    public PrivateWord() {
    }
    
    public PrivateWord(String privateword, int publisherid, String publisherdate) {
        this.privateword = privateword;
        this.publisherid = publisherid;
        this.publisherdate = publisherdate;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPrivateword() {
        return privateword;
    }
    
    public void setPrivateword(String privateword) {
        this.privateword = privateword;
    }
    
    public int getPublisherid() {
        return publisherid;
    }
    
    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }
    
    public int getReplierid() {
        return replierid;
    }
    
    public void setReplierid(int replierid) {
        this.replierid = replierid;
    }
    
    public String getReplycontent() {
        return replycontent;
    }
    
    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }
    
    public String getPublisherdate() {
        return publisherdate;
    }
    
    public void setPublisherdate(String publisherdate) {
        this.publisherdate = publisherdate;
    }
}