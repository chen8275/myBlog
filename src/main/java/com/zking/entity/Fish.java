package com.zking.entity;

public class Fish {
    private Integer id;

    private String name;

    private String publishname;

    private Float price;

    public Fish(Integer id, String name, String publishname, Float price) {
        this.id = id;
        this.name = name;
        this.publishname = publishname;
        this.price = price;
    }

    public Fish() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPublishname() {
        return publishname;
    }

    public void setPublishname(String publishname) {
        this.publishname = publishname == null ? null : publishname.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}