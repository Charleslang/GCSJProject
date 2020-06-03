package com.itheima.user.dto;

import java.util.Date;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
public class UpdateOrderDTO {
    private Integer orderId;
    private Date payTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
