package com.zking.entity;

public class Categories {
    private Integer id;

    private String categoryname;

    public Categories(Integer id, String categoryname) {
        this.id = id;
        this.categoryname = categoryname;
    }

    public Categories() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }
}