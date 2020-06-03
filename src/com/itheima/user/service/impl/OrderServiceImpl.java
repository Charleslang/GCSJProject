package com.itheima.user.service.impl;

import com.itheima.entity.TbOrder;
import com.itheima.user.dao.OrderDao;
import com.itheima.user.dto.UpdateOrderDTO;
import com.itheima.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Map<String, Integer> insertOrder(TbOrder tbOrder) {
        int insert = orderDao.insertOrder(tbOrder);
        Map<String,Integer> resultMap = null;
        if (insert == 1) {
            resultMap.put("orderId", tbOrder.getOrderId());
        } else {
            resultMap.put("status", 0);
        }
        return resultMap;
    }

    @Override
    public Map<String, Boolean> updateOrderStatus(UpdateOrderDTO updateOrderDTO) {
        int update = orderDao.updateOrderStatus(updateOrderDTO);
        Map<String,Boolean> resultMap = null;
        if (update == 1) {
            resultMap.put("code", true);
        } else {
            resultMap.put("code", false);
        }
        return resultMap;
    }
}
