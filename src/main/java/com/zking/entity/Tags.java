package com.zking.entity;

public class Tags {
    private Integer id;

    private String tagname;

    private Integer tagsize;

    public Tags(Integer id, String tagname, Integer tagsize) {
        this.id = id;
        this.tagname = tagname;
        this.tagsize = tagsize;
    }

    public Tags() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }

    public Integer getTagsize() {
        return tagsize;
    }

    public void setTagsize(Integer tagsize) {
        this.tagsize = tagsize;
    }
}