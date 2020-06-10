package com.itheima.pay.service.impl;

import com.itheima.pay.common.TradeStatusEnum;
import com.itheima.pay.service.AlipayService;
import com.itheima.pay.util.OrderInfoUtil2_0;
import com.itheima.user.dto.PayOrderDTO;
import com.itheima.user.dto.UpdateOrderDTO;
import com.itheima.user.service.impl.OrderServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    @Override
    public String updateOrderInfo(Map<String, String> params) {
        if (params == null || params.isEmpty()){
            return "success";
        }
        Integer orderId = Integer.parseInt(params.get("out_trade_no"));
        PayOrderDTO order = orderService.getOrderById(orderId);
        // 如果订单不存在，则支付操作无意义
        // 不让支付宝再继续调用异步通知（返回为 SUCCESS 后，支付宝将不再调用）。
        if (order == null) {
            return "success";
        }
        // 判断订单状态是否已经被修改
        int orderStatus = orderService.getOrderStatus(orderId);
        if (orderStatus == 1){
            return "success";
        }
        String tradeStatus = params.get("trade_status");
        if ("TRADE_SUCCESS".equals(tradeStatus)){
            UpdateOrderDTO updateOrderDTO = new UpdateOrderDTO();
            updateOrderDTO.setOrderId(Integer.parseInt(params.get("out_trade_no")));
            updateOrderDTO.setPayPrice(Float.parseFloat(params.get("total_amount")));
            updateOrderDTO.setPayTime(Timestamp.valueOf(params.get("gmt_payment")));
            String result = orderService.updateOrderStatus(updateOrderDTO);
            if ("success".equals(result)) {
                System.out.println("订单支付成功service");
                return "success";
            }
        }
        return "fail";
    }
}
