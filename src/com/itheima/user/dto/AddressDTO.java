package com.itheima.user.dto;

import javax.validation.constraints.NotNull;

public class AddressDTO {
    /**
     * 页大小
     */
    @NotNull(message = "页大小不能为空")
    private Integer pageSize;
    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    /**
     * 用户id
     */
    private String userId;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
