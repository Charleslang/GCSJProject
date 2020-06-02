package com.itheima.user.service;

import com.itheima.entity.TbOrder;
import com.itheima.user.dto.UpdateOrderDTO;

import java.util.Map;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
public interface OrderService {

    Map<String,Integer> insertOrder(TbOrder tbOrder);
    Map<String,Boolean> updateOrderStatus(UpdateOrderDTO updateOrderDTO);
}
