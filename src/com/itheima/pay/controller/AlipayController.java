package com.itheima.pay.controller;

import com.itheima.pay.service.impl.AlipayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-10
 **/
@RestController
@RequestMapping("/alipay")
public class AlipayController {

    @Autowired
    AlipayServiceImpl alipayService;

    @GetMapping("/pay")
    public String alipay(Integer orderId){
        String orderInfo = alipayService.alipay(orderId);
        return orderInfo;
    }

    @RequestMapping("/callback")
    public String alipayCallback(){
        return "success";
    }
}
