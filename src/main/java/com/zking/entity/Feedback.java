package com.zking.entity;

public class Feedback {
    
    private Integer id;

    private String contactinfo;

    private Integer personid;

    private String feedbackdate;

    private String feedbackcontent;

    public Feedback(Integer id, String contactinfo, Integer personid, String feedbackdate, String feedbackcontent) {
        this.id = id;
        this.contactinfo = contactinfo;
        this.personid = personid;
        this.feedbackdate = feedbackdate;
        this.feedbackcontent = feedbackcontent;
    }

    public Feedback() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo == null ? null : contactinfo.trim();
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public String getFeedbackdate() {
        return feedbackdate;
    }

    public void setFeedbackdate(String feedbackdate) {
        this.feedbackdate = feedbackdate == null ? null : feedbackdate.trim();
    }

    public String getFeedbackcontent() {
        return feedbackcontent;
    }

    public void setFeedbackcontent(String feedbackcontent) {
        this.feedbackcontent = feedbackcontent == null ? null : feedbackcontent.trim();
    }
}