package com.zking.entity;

public class Shop {
    private Integer id;

    private String name;

    private String location;

    public Shop(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Shop() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }
}