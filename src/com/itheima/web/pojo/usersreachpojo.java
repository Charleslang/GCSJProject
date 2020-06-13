package com.itheima.web.pojo;

import java.sql.Date;

/**
 * @Author ChenKai
 * @Date 2020/6/13/013 10:01
 * @Version 1.0
 */
public class usersreachpojo {
    private java.sql.Date start;
    private java.sql.Date end;
    private String uname;

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
}
