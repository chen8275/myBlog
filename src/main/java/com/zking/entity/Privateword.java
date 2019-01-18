package com.zking.entity;

public class Privateword {
    private Integer id;

    private String privateword;

    private String publisherid;

    private String replierid;

    private String replycontent;

    private String publisherdate;

    public Privateword(Integer id, String privateword, String publisherid, String replierid, String replycontent, String publisherdate) {
        this.id = id;
        this.privateword = privateword;
        this.publisherid = publisherid;
        this.replierid = replierid;
        this.replycontent = replycontent;
        this.publisherdate = publisherdate;
    }

    public Privateword() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivateword() {
        return privateword;
    }

    public void setPrivateword(String privateword) {
        this.privateword = privateword == null ? null : privateword.trim();
    }

    public String getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(String publisherid) {
        this.publisherid = publisherid == null ? null : publisherid.trim();
    }

    public String getReplierid() {
        return replierid;
    }

    public void setReplierid(String replierid) {
        this.replierid = replierid == null ? null : replierid.trim();
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public String getPublisherdate() {
        return publisherdate;
    }

    public void setPublisherdate(String publisherdate) {
        this.publisherdate = publisherdate == null ? null : publisherdate.trim();
    }
}