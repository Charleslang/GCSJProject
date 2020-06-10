package com.itheima.user.dto;


import java.sql.Timestamp;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
public class UpdateOrderDTO {
    private Integer orderId;
    private Float payPrice;
    private Timestamp payTime;

    public Float getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Float payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }
}
