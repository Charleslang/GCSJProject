package com.itheima.user.service;

import com.itheima.entity.TbOrder;
import com.itheima.user.dto.OrderDTO;

import java.util.List;

public interface UserOrderService {
    List<TbOrder> selectOrderList(OrderDTO orderDTO);
}
