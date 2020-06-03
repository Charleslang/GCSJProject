package com.itheima.user.controller;

import com.itheima.entity.TbOrder;
import com.itheima.user.dto.UpdateOrderDTO;
import com.itheima.user.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/insert")
    public Map<String, Integer> insertOrder(@RequestBody TbOrder tbOrder){
        Map<String, Integer> resultMap = orderService.insertOrder(tbOrder);
        return resultMap;
    }

    @PostMapping("/update")
    public Map<String, Boolean> updateOrderStatus(@RequestBody UpdateOrderDTO updateOrderDTO){
        Map<String, Boolean> resultMap = orderService.updateOrderStatus(updateOrderDTO);
        return resultMap;
    }
}
