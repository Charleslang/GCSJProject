package com.itheima.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateAddressDTO {
    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空")
    private String details;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String username;
    /**
     * 手机号
     */
    @NotBlank(message = "手机不能为空")
    private String phone;

    /**
     * 地址id
     */
    @NotNull(message = "地址id不能为空")
    private Integer addressId;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
