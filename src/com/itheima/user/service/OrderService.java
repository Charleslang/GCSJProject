package com.itheima.user.service;

import com.itheima.user.dto.InsertOrderDTO;
import com.itheima.user.dto.PayOrderDTO;
import com.itheima.user.dto.UpdateOrderDTO;


/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
public interface OrderService {

    Integer insertOrder(InsertOrderDTO insertOrderDTO);
    String updateOrderStatus(UpdateOrderDTO updateOrderDTO);
    PayOrderDTO getOrderById(Integer orderId);
    int getOrderStatus(Integer orderId);
}
