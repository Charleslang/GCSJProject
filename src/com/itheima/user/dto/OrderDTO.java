package com.itheima.user.dto;

import javax.validation.constraints.NotNull;

public class OrderDTO {
    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    private Integer pageNum;
    /**
     * 页大小
     */
    @NotNull(message = "页大小不能为空")
    private Integer pageSize;
    /**
     * 订单状态
     */
    @NotNull(message = "订单状态不能为空")
    private Integer orderStatus;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
