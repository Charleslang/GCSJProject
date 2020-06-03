package com.itheima.entity;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
public class TbCart {
    private Integer cartId;
    private Integer goodsNum;
    private Float allPrice;
    private Integer cartStatus;
    private String userId;
    private Integer goodsId;
    private String goodsName;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Float getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Float allPrice) {
        this.allPrice = allPrice;
    }

    public Integer getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(Integer cartStatus) {
        this.cartStatus = cartStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
