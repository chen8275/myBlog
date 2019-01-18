package com.zking.entity;

public class LeaveMessageLikesRecord {
    private Integer id;

    private String pagename;

    private Integer pid;

    private Integer likerid;

    private String likedate;

    public LeaveMessageLikesRecord(Integer id, String pagename, Integer pid, Integer likerid, String likedate) {
        this.id = id;
        this.pagename = pagename;
        this.pid = pid;
        this.likerid = likerid;
        this.likedate = likedate;
    }

    public LeaveMessageLikesRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename == null ? null : pagename.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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