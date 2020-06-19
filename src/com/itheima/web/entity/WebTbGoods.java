package com.itheima.web.entity;

import java.io.Serializable;

/**
 * 商品实体类
 *
 * @author Lv Bo
 * @create: 2020-06-05
 * @version 1.0
 **/
public class WebTbGoods implements Serializable {
    private Integer gId;
    private String gName;
    private Float gPrice;
    private Integer gNumber;
    private Integer gType;
    private String gPhoto;
    private String gAddTime;
    private WebTbGoodsType webTbGoodsType;

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

    public String getgAddTime() {
        return gAddTime;
    }

    public void setgAddTime(String gAddTime) {
        this.gAddTime = gAddTime;
    }

    public WebTbGoodsType getWebTbGoodsType() {
        return webTbGoodsType;
    }

    public void setWebTbGoodsType(WebTbGoodsType webTbGoodsType) {
        this.webTbGoodsType = webTbGoodsType;
    }

    @Override
    public String toString() {
        return "WebTbGoods{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", gNumber=" + gNumber +
                ", gType=" + gType +
                ", gPhoto='" + gPhoto + '\'' +
                ", gAddTime='" + gAddTime + '\'' +
                ", webTbGoodsType=" + webTbGoodsType.toString() +
                '}';
    }
}
