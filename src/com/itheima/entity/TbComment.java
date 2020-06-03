package com.itheima.entity;

import java.util.Date;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
public class TbComment {
    private Integer cId;
    private Integer cUserId;
    private Integer cUserType;
    private String cComment;
    private Date cTime;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getcUserId() {
        return cUserId;
    }

    public void setcUserId(Integer cUserId) {
        this.cUserId = cUserId;
    }

    public Integer getcUserType() {
        return cUserType;
    }

    public void setcUserType(Integer cUserType) {
        this.cUserType = cUserType;
    }

    public String getcComment() {
        return cComment;
    }

    public void setcComment(String cComment) {
        this.cComment = cComment;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
