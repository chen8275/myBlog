package com.zking.entity;

public class Categories {
    private Integer id;

    private String categoryname;
    
    private String displayname;
    
    public String getDisplayname() {
        return displayname;
    }
    
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
    
    public Categories(Integer id, String categoryname, String displayname) {
        this.id = id;
        this.categoryname = categoryname;
        this.displayname = displayname;
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