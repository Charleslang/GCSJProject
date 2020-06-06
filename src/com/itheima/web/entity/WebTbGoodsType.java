package com.itheima.web.entity;

import java.io.Serializable;

/**
 * 商品类型实体类
 *
 * @author: Lv Bo
 * @create: 2020-06-05
 *
 **/
public class WebTbGoodsType implements Serializable {
    private Integer typeId;
    private String typeName;
    //private ArrayList<WebTbGoods> tbGoods;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "WebTbGoodsType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
