package com.zking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveMessageRecord {
    private Integer id;

    private String pagename;

    private Integer pid;

    private Integer answererid;

    private Integer respondentid;

    private String leavemessagedate;

    private Integer likes;

    private String leavemessagecontent;
    
    public LeaveMessageRecord(String pagename, Integer answererid, Integer respondentid, String leavemessagedate, String leavemessagecontent) {
        this.pagename = pagename;
        this.answererid = answererid;
        this.respondentid = respondentid;
        this.leavemessagedate = leavemessagedate;
        this.leavemessagecontent = leavemessagecontent;
    }
}