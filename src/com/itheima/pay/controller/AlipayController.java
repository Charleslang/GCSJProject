package com.itheima.pay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.itheima.pay.service.AlipayService;
import com.itheima.pay.service.impl.AlipayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    // 异步回调
    @PostMapping("/callback")
    public String alipayCallback(HttpServletRequest request){
        System.out.println("进入异步回调");
        String success = "success";
        String fail = "fail";
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        if (requestParams == null) {
            return fail;
        }
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        params.remove("sign_type");
        try {
            boolean checkV2 = AlipaySignature.rsaCheckV2(params, AlipayService.PUBLICKEY, "utf-8", "RSA2");
            // 验签通过
            if (checkV2) {
                String result = alipayService.updateOrderInfo(params);
                if ("success".equals(result)) {
                    System.out.println("订单支付成功controller");
                    return success;
                }
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return fail;
    }
}
