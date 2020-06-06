package com.itheima.user.service;

import com.itheima.entity.TbOrder;
import com.itheima.user.dto.OrderDTO;
import com.itheima.user.pojo.UserOrder;

import java.util.List;

public interface UserOrderService {
    List<UserOrder> selectOrderList(OrderDTO orderDTO);
}
