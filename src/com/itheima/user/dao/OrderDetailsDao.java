package com.itheima.user.dao;

import com.itheima.entity.TbOrderDetails;
import com.itheima.user.dto.OrderDetailsDTO;

import java.util.List;

public interface OrderDetailsDao {

    /**
     * 功能描述：生成订单明细
     * @param detailsList 所有商品的明细
     * @return 明细的生成数量
     */
    int insertOrderDetail(List<OrderDetailsDTO> detailsList);
}
