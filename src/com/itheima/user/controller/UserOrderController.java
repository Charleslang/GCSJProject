package com.itheima.user.controller;

import com.itheima.common.Result;
import com.itheima.common.redis.JedisUtil;
import com.itheima.common.validator.DTOValidatorAnnotation;
import com.itheima.user.dto.OrderDTO;
import com.itheima.user.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户个人中心的订单
 *
 * @author: qinjie
 **/
@RestController
@RequestMapping("/users")
public class UserOrderController {

    @Resource
    private JedisUtil jedisUtil;
    @Autowired
    private UserOrderService userOrderService;
   @GetMapping("/orders")
   @DTOValidatorAnnotation
    Result orders(OrderDTO orderDTO){
       return Result.ok(userOrderService.selectOrderList(orderDTO));
   }
    @GetMapping("/orders/{orderId}")
    @DTOValidatorAnnotation
    Result orders(@PathVariable Integer orderId){

        return Result.ok();
    }
}
