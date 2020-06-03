package com.itheima.user.service;

import com.itheima.entity.TbAddress;
import com.itheima.entity.TbOrder;
import com.itheima.user.dto.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface UserPersonService {

    /**
     * 功能描述: 更新用户信息
     * @param updateUserDTO 更新用户信息时相关参数
     * @return java.lang.Integer
     */
    Integer updateUserInfo(UpdateUserDTO updateUserDTO) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
    /**
     * 功能描述: 得到地址列表
     * @param addressDTO pageSize和pageNum。
     * @return java.util.List<com.itheima.entity.TbAddress>
     */
    List<TbAddress> selectAddressList(AddressDTO addressDTO);

    /**
     * 功能描述: 更新收货地址
     * @param updateAddressDTO 包含详细地址和地址id和所在大学
     * @return void
     */
    void updateAddress(UpdateAddressDTO updateAddressDTO);

    /**
     * 功能描述: 新增地址
     * @param insertAddressDTO 包含详细地址，大学
     * @return void
     */
    void insertAddress(InsertAddressDTO insertAddressDTO);
    /**
     * 功能描述: 更新默认地址
     * @param addressId 地址id
     * @return void
     */
    void updateUserDefault(Integer addressId);
    /**
     * 功能描述: 删除地址
     * @param addressId 地址id
     * @return void
     */
    void deleteAddress(Integer addressId);
}
