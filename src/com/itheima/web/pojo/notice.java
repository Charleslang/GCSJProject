package com.itheima.web.pojo;

import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class notice {
    private String nTitle;
    private String nContent;

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public Date getnPubTime() {
        return nPubTime;
    }

    public void setnPubTime(Date nPubTime) {
        this.nPubTime = nPubTime;
    }

    private java.sql.Date nPubTime;

    @Override
    public String toString(){
        return "notice{" +
                "nTitle='" + nTitle + '\'' +
                ", nContent='" + nContent + '\'' +
                ", nPubTime='" + nPubTime + '\'' +
                '}';
    }
}
