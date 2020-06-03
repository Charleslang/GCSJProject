package com.itheima.user.dao;

import com.itheima.entity.TbAddress;
import com.itheima.entity.TbUser;
import com.itheima.entity.TbUserQq;
import com.itheima.user.dto.AddressDTO;
import com.itheima.user.dto.UpdateAddressDTO;
import com.itheima.user.pojo.UserQQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPersonDao {
    //更新用户信息
    Integer updateUserInfoById(TbUser tbUser);


    //用户地址列表
    List<List<?>> selectAddressList(AddressDTO addressDTO);
    //更新地址
    Integer updateAddress(UpdateAddressDTO updateAddressDTO);
    //新增地址
    Integer insertAddress(TbAddress tbAddress);
    //设置默认地址
    Integer updateUserDefault(@Param("userId")String userId, @Param("addressId")Integer addressId);
    //删除地址
    Integer deleteAddress(Integer addressId);
}
