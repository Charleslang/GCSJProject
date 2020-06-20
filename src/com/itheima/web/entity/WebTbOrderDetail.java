package com.itheima.web.entity;

import java.io.Serializable;

public class WebTbOrderDetail implements Serializable {
    private Integer deId;
    private Integer gId;
    private Integer oId;
    private float gPrice;
    private String gName;
    private String gImg;

    public Integer getDeId() {
        return deId;
    }

    public void setDeId(Integer deId) {
        this.deId = deId;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public float getgPrice() {
        return gPrice;
    }

    public void setgPrice(float gPrice) {
        this.gPrice = gPrice;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgImg() {
        return gImg;
    }

    public void setgImg(String gImg) {
        this.gImg = gImg;
    }

    public Integer getgNum() {
        return gNum;
    }

    public void setgNum(Integer gNum) {
        this.gNum = gNum;
    }

    private Integer gNum;
}
