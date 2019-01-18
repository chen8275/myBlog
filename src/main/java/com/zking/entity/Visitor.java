package com.zking.entity;

public class Visitor {
    private Integer id;

    private Long visitornum;

    private String pagename;

    public Visitor(Integer id, Long visitornum, String pagename) {
        this.id = id;
        this.visitornum = visitornum;
        this.pagename = pagename;
    }

    public Visitor() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getVisitornum() {
        return visitornum;
    }

    public void setVisitornum(Long visitornum) {
        this.visitornum = visitornum;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename == null ? null : pagename.trim();
    }
}