package com.itheima.user.dao;

import com.itheima.user.dto.InsertOrderDTO;
import com.itheima.user.dto.PayOrderDTO;
import com.itheima.user.dto.UpdateOrderDTO;

public interface OrderDao {
    int insertOrder(InsertOrderDTO insertOrderDTO);
    int updateOrderStatus(UpdateOrderDTO updateOrderDTO);
    PayOrderDTO getOrderById(Integer orderId);
}
