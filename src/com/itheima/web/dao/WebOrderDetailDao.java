package com.itheima.web.dao;
import com.itheima.web.entity.WebTbOrderDetail;
import com.itheima.web.pojo.sreachorderdetailpojo;

import java.util.List;

public interface WebOrderDetailDao {
    List<WebTbOrderDetail> getallorder();
    void deletbyid(Integer c_id);
    Integer deleteall(Integer[] ids);
    List<WebTbOrderDetail> sreachorder(sreachorderdetailpojo sreachorderdetailpojo);
}
