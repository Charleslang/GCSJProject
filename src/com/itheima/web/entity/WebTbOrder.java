package com.itheima.web.entity;

import java.io.Serializable;
import java.sql.Date;

public class WebTbOrder implements Serializable {
    private Integer oId;
    private float pPrice;
    private java.sql.Date oTime;
    private java.sql.Date pTime;
    private Integer oStatus;
    private String uId;
    private Integer uType;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public float getpPrice() {
        return pPrice;
    }

    public void setpPrice(float pPrice) {
        this.pPrice = pPrice;
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    public Integer getoStatus() {
        return oStatus;
    }

    public void setoStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Integer getuType() {
        return uType;
    }

    public void setuType(Integer uType) {
        this.uType = uType;
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    public String getuAddr() {
        return uAddr;
    }

    public void setuAddr(String uAddr) {
        this.uAddr = uAddr;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    private String uNickname;
    private String uAddr;
    private String storeName;
}
