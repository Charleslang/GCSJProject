package com.itheima.pay.service.impl;

import com.itheima.pay.service.AlipayService;
import com.itheima.pay.util.OrderInfoUtil2_0;
import com.itheima.user.dto.PayOrderDTO;
import com.itheima.user.service.impl.OrderServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-10
 **/
@Service
public class AlipayServiceImpl implements AlipayService {

    @Autowired
    OrderServiceImpl orderService;

    @Override
    public String alipay(Integer orderId) {
        if (StringUtils.isEmpty(APPID) || (StringUtils.isEmpty(RSA2_PRIVATE))) {
            String fail = "fail";
            return fail;
        }
        PayOrderDTO order = orderService.getOrderById(orderId);
        if (order != null){
            Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, true, order, NOTIFY_URL);
            String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
            String sign = OrderInfoUtil2_0.getSign(params, RSA2_PRIVATE, true);
            final String orderInfo = orderParam + "&" + sign;
            System.out.println("支付宝的订单信息\n" + orderInfo);
            return orderInfo;
        }
        return "";
    }
}
