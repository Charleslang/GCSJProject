package com.itheima.user.dto;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-09
 **/
public class OrderDetailsDTO {
    private Integer detailsId;
    private Integer goodsId;
    private Integer orderId;
    private Float goodsPrice;
    private String goodsName;
    private String goodsImg;
    private Integer goodsNum;
    private Integer stockNum;

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "detailsId=" + detailsId +
                ", goodsId=" + goodsId +
                ", orderId=" + orderId +
                ", goodsPrice=" + goodsPrice +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsNum=" + goodsNum +
                ", stockNum=" + stockNum +
                '}';
    }
}
