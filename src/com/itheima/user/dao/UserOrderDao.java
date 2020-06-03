package com.itheima.user.dao;

import com.itheima.user.dto.OrderDTO;

import java.util.List;

public interface UserOrderDao {
    //得到订单列表
    List<List<?>> selectOrderList(OrderDTO orderDTO);
}
