package com.zking.entity;

public class LeaveMessageRecord {
    private Integer id;

    private String pagename;

    private Integer pid;

    private Integer answererid;

    private Integer respondentid;

    private String leavemessagedate;

    private Integer likes;

    private String leavemessagecontent;

    public LeaveMessageRecord(Integer id, String pagename, Integer pid, Integer answererid, Integer respondentid, String leavemessagedate, Integer likes, String leavemessagecontent) {
        this.id = id;
        this.pagename = pagename;
        this.pid = pid;
        this.answererid = answererid;
        this.respondentid = respondentid;
        this.leavemessagedate = leavemessagedate;
        this.likes = likes;
        this.leavemessagecontent = leavemessagecontent;
    }

    public LeaveMessageRecord() {
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

    public String getLeavemessagedate() {
        return leavemessagedate;
    }

    public void setLeavemessagedate(String leavemessagedate) {
        this.leavemessagedate = leavemessagedate == null ? null : leavemessagedate.trim();
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getLeavemessagecontent() {
        return leavemessagecontent;
    }

    public void setLeavemessagecontent(String leavemessagecontent) {
        this.leavemessagecontent = leavemessagecontent == null ? null : leavemessagecontent.trim();
    }
}