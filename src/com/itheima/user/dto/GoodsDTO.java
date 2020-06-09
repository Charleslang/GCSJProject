package com.itheima.user.dto;

import com.itheima.entity.TbGoodsType;

import java.sql.Date;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-06
 **/
public class GoodsDTO {
    private Integer gId;
    private String gName;
    private Float gPrice;
    private Integer gNumber;
    private Integer selectNum = 0;
    private String gPhoto;
    private TbGoodsType tbGoodsType;

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

    public Integer getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(Integer selectNum) {
        this.selectNum = selectNum;
    }

    public String getgPhoto() {
        return gPhoto;
    }

    public void setgPhoto(String gPhoto) {
        this.gPhoto = gPhoto;
    }

    public TbGoodsType getTbGoodsType() {
        return tbGoodsType;
    }

    public void setTbGoodsType(TbGoodsType tbGoodsType) {
        this.tbGoodsType = tbGoodsType;
    }

    public Integer getgNumber() {
        return gNumber;
    }

    public void setgNumber(Integer gNumber) {
        this.gNumber = gNumber;
    }

    @Override
    public String toString() {
        return "GoodsDTO{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", selectNum=" + selectNum +
                ", gPhoto='" + gPhoto + '\'' +
                ", tbGoodsType=" + tbGoodsType +
                '}';
    }
}
