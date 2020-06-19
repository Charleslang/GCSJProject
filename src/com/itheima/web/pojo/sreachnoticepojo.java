package com.itheima.web.pojo;

import java.sql.Date;

public class sreachnoticepojo {
    private java.sql.Date start;
    private java.sql.Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    private String uname;
}
