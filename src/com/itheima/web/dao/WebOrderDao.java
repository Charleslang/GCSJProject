package com.itheima.web.dao;

import com.itheima.web.entity.WebTbOrder;
import com.itheima.web.pojo.sreachorderpojo;

import java.util.List;

public interface WebOrderDao {
    List<WebTbOrder> getallorder();
    void deletbyid(Integer c_id);
    Integer deleteall(Integer[] ids);
    List<WebTbOrder> sreachorder(sreachorderpojo sreachorderpojo);
}
