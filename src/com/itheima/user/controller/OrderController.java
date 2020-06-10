package com.itheima.user.controller;

import com.itheima.entity.TbOrder;
import com.itheima.user.dto.InsertOrderDTO;
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
    public Integer insertOrder(@RequestBody InsertOrderDTO insertOrderDTO){
        System.out.println("进入订单controller");
        Integer orderId = orderService.insertOrder(insertOrderDTO);
        return orderId;
    }

//    @PostMapping("/update")
//    public Map<String, Boolean> updateOrderStatus(@RequestBody UpdateOrderDTO updateOrderDTO){
//        Map<String, Boolean> resultMap = orderService.updateOrderStatus(updateOrderDTO);
//        return resultMap;
//    }
}
