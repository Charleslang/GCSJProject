package com.itheima.entity;

import java.util.Date;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
public class TbGoods {
    private Integer gId;
    private String gName;
    private Float gPrice;
    private Integer gNumber;
    private Integer gType;
    private String gPhoto;
    private Date gAddTime;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Float getgPrice() {
        return gPrice;
    }

    public void setgPrice(Float gPrice) {
        this.gPrice = gPrice;
    }

    public Integer getgNumber() {
        return gNumber;
    }

    public void setgNumber(Integer gNumber) {
        this.gNumber = gNumber;
    }

    public Integer getgType() {
        return gType;
    }

    public void setgType(Integer gType) {
        this.gType = gType;
    }

    public String getgPhoto() {
        return gPhoto;
    }

    public void setgPhoto(String gPhoto) {
        this.gPhoto = gPhoto;
    }

    public Date getgAddTime() {
        return gAddTime;
    }

    public void setgAddTime(Date gAddTime) {
        this.gAddTime = gAddTime;
    }
}
