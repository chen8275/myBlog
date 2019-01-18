package com.zking.entity;

public class ArticleLikesRecord {
    private Integer id;

    private Long articleid;

    private String originalauthor;

    private Integer likerid;

    private String likedate;

    public ArticleLikesRecord(Integer id, Long articleid, String originalauthor, Integer likerid, String likedate) {
        this.id = id;
        this.articleid = articleid;
        this.originalauthor = originalauthor;
        this.likerid = likerid;
        this.likedate = likedate;
    }

    public ArticleLikesRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getLikerid() {
        return likerid;
    }

    public void setLikerid(Integer likerid) {
        this.likerid = likerid;
    }

    public String getLikedate() {
        return likedate;
    }

    public void setLikedate(String likedate) {
        this.likedate = likedate == null ? null : likedate.trim();
    }
}