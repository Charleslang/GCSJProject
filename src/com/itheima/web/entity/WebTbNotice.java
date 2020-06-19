package com.itheima.web.entity;

import java.io.Serializable;

public class WebTbNotice implements Serializable {
    private Integer nId;
    private String nTitle;
    private String nContent;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

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

    public String getnPubtime() {
        return nPubtime;
    }

    public void setnPubtime(String nPubtime) {
        this.nPubtime = nPubtime;
    }

    private String nPubtime;
}
