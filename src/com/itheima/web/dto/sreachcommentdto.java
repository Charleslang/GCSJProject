package com.itheima.web.dto;

/**
 * @Author ChenKai
 * @Date 2020/6/12/012 21:26
 * @Version 1.0
 */
public class sreachcommentdto {
    private String start;
    private String end;
    private String uname;
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    @Override
    public String toString() {
        return "sreachcommentdto{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}
