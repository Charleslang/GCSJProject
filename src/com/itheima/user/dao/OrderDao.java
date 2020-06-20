package com.itheima.user.dao;

import com.itheima.user.dto.InsertOrderDTO;
import com.itheima.user.dto.OrderAddressDTO;
import com.itheima.user.dto.PayOrderDTO;
import com.itheima.user.dto.UpdateOrderDTO;

public interface OrderDao {

    /**
     * 功能描述：生成订单信息
     * @param insertOrderDTO 订单信息
     * @return 生成订单的结果
     */
    int insertOrder(InsertOrderDTO insertOrderDTO);

    /**
     * 功能描述：更新订单状态
     * @param updateOrderDTO 订单的更新信息
     * @return 更新结果（成功：1）
     */
    int updateOrderStatus(UpdateOrderDTO updateOrderDTO);

    /**
     * 功能描述：通过订单ID查询订单支付信息
     * @param orderId 订单ID
     * @return 订单支付信息
     */
    PayOrderDTO getOrderById(Integer orderId);

    /**
     * 功能描述：查询订单支付状态
     * @param orderId 订单ID
     * @return 订单支付状态（1：已支付）
     */
    int getOrderStatus(Integer orderId);

    /**
     * 功能描述：查询收货地址
     * @param userId 用户ID
     * @return 收货地址信息
     */
    OrderAddressDTO getOrderAddr(String userId);
}
