package com.itheima.user.dao;

import com.itheima.entity.TbOrder;
import com.itheima.user.dto.UpdateOrderDTO;

public interface OrderDao {
    int insertOrder(TbOrder tbOrder);
    int updateOrderStatus(UpdateOrderDTO updateOrderDTO);
}
