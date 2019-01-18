package com.zking.entity;

public class Archives {
    private Integer id;

    private String archivename;

    public Archives(Integer id, String archivename) {
        this.id = id;
        this.archivename = archivename;
    }

    public Archives() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArchivename() {
        return archivename;
    }

    public void setArchivename(String archivename) {
        this.archivename = archivename == null ? null : archivename.trim();
    }
}