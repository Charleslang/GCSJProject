package com.itheima.user.dto;

import com.itheima.entity.TbOrderDetails;

import java.util.List;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-08
 **/
public class InsertOrderDTO {

    private Integer orderId;
    private String userId;
    private Integer userType;
    private String userNickname;
    private String userAddr;
    private String goodsImage;
    private String storeName;
    private String orderNo;
    private List<OrderDetailsDTO> orderDetailsList;

    public InsertOrderDTO() {

    }

    public InsertOrderDTO(String userId, Integer userType, String userNickname, String userAddr, String goodsImage, String storeName, String orderNo, List<OrderDetailsDTO> orderDetailsList) {
        this.userId = userId;
        this.userType = userType;
        this.userNickname = userNickname;
        this.userAddr = userAddr;
        this.goodsImage = goodsImage;
        this.storeName = storeName;
        this.orderNo = orderNo;
        this.orderDetailsList = orderDetailsList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<OrderDetailsDTO> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetailsDTO> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}
