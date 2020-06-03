package com.itheima.user.dto;

import javax.validation.constraints.NotNull;

public class AddressDefaultDTO {
    /**
     * 地址id
     */
    @NotNull(message = "地址id不能为空")
    private Integer addressId;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
