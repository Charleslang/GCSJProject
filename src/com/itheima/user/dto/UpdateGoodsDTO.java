package com.itheima.user.dto;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-09
 **/
public class UpdateGoodsDTO {
    private Integer gId;
    private Integer gNumber;

    public UpdateGoodsDTO() {

    }

    public UpdateGoodsDTO(Integer gId, Integer gNumber) {
        this.gId = gId;
        this.gNumber = gNumber;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getgNumber() {
        return gNumber;
    }

    public void setgNumber(Integer gNumber) {
        this.gNumber = gNumber;
    }
}
