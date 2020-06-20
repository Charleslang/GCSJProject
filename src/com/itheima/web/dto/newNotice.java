package com.itheima.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class newNotice {
    private String nTitle;
    private String nContent;

    public String getnTitle() {
        return nTitle;
    }
    @JsonProperty(value = "nTitle")
    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }


    public String getnContent() {
        return nContent;
    }
    @JsonProperty(value = "nContent")
    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    @Override
    public String toString(){
        return "newNotice{" +
                "nTitle='" + nTitle + '\'' +
                ", nContent='" + nContent + '\'' +
                '}';
    }

}
