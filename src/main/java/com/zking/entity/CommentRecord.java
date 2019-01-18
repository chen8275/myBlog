package com.zking.entity;

public class CommentRecord {
    private Long id;

    private Long pid;

    private Long articleid;

    private String originalauthor;

    private Integer answererid;

    private Integer respondentid;

    private String commentdate;

    private Integer likes;

    private String commentcontent;

    public CommentRecord(Long id, Long pid, Long articleid, String originalauthor, Integer answererid, Integer respondentid, String commentdate, Integer likes, String commentcontent) {
        this.id = id;
        this.pid = pid;
        this.articleid = articleid;
        this.originalauthor = originalauthor;
        this.answererid = answererid;
        this.respondentid = respondentid;
        this.commentdate = commentdate;
        this.likes = likes;
        this.commentcontent = commentcontent;
    }

    public CommentRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getArticleid() {
        return articleid;
    }

    public void setArticleid(Long articleid) {
        this.articleid = articleid;
    }

    public String getOriginalauthor() {
        return originalauthor;
    }

    public void setOriginalauthor(String originalauthor) {
        this.originalauthor = originalauthor == null ? null : originalauthor.trim();
    }

    public Integer getAnswererid() {
        return answererid;
    }

    public void setAnswererid(Integer answererid) {
        this.answererid = answererid;
    }

    public Integer getRespondentid() {
        return respondentid;
    }

    public void setRespondentid(Integer respondentid) {
        this.respondentid = respondentid;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate == null ? null : commentdate.trim();
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent.trim();
    }
}