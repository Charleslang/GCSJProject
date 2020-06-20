package com.itheima.user.controller;

import com.itheima.common.redis.JedisUtil;
import com.itheima.common.utils.CommonUtils;
import com.itheima.entity.TbOrder;
import com.itheima.user.dto.InsertOrderDTO;
import com.itheima.user.dto.OrderAddressDTO;
import com.itheima.user.dto.UpdateOrderDTO;
import com.itheima.user.pojo.User;
import com.itheima.user.pojo.UserOrdinary;
import com.itheima.user.pojo.UserQQ;
import com.itheima.user.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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

    @Resource
    private JedisUtil jedisUtil;

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

    @GetMapping("/addr")
    public OrderAddressDTO getUserAddr(@RequestHeader("token") String token){
        OrderAddressDTO orderAddressDTO = null;
        String userId = "";
        System.out.println("token信息：" + token);
        User user = CommonUtils.getCurrentUser(jedisUtil);
        if (user instanceof UserOrdinary) {
            userId = String.valueOf(((UserOrdinary) user).getmUserId());
            orderAddressDTO = orderService.getOrderAddr(userId);
            orderAddressDTO.setUserType(1);
        } else {
            userId = ((UserQQ) user).getmOpenid();
            orderAddressDTO = orderService.getOrderAddr(userId);
            orderAddressDTO.setUserType(2);
        }
        System.out.println(orderAddressDTO);
        return orderAddressDTO;
    }
}
