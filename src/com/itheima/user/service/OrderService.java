package com.itheima.user.service;

import com.itheima.user.dto.InsertOrderDTO;
import com.itheima.user.dto.OrderAddressDTO;
import com.itheima.user.dto.PayOrderDTO;
import com.itheima.user.dto.UpdateOrderDTO;


/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
public interface OrderService {

    /**
     * 功能描述：生成订单信息
     * @param insertOrderDTO 订单信息
     * @return java.lang.Integer 生成订单的结果
     */
    Integer insertOrder(InsertOrderDTO insertOrderDTO);

    /**
     * 功能描述：更新订单状态
     * @param updateOrderDTO 订单的更新信息
     * @return java.lang.String 更新结果（成功：success）
     */
    String updateOrderStatus(UpdateOrderDTO updateOrderDTO);

    /**
     * 功能描述：通过订单ID查询订单支付信息
     * @param orderId 订单ID
     * @return 订单支付信息
     */
    PayOrderDTO getOrderById(Integer orderId);

    /**
     * 功能描述：查询订单支付状态
     * @param orderId 订单ID
     * @return 订单支付状态
     */
    int getOrderStatus(Integer orderId);

    /**
     * 功能描述：查询收货地址
     * @param userId 用户ID
     * @return 收货地址信息
     */
    OrderAddressDTO getOrderAddr(String userId);
}
