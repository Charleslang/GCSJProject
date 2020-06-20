package com.itheima.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author ChenKai
 * @Date 2020/6/8/008 17:01
 * @Version 1.0
 */
public class WebTbComments implements Serializable {
    private Integer cId;
    private String cUsername;
    private Integer cUserId;
    private Integer cUserType;
    private String cComment;
    private java.sql.Date cTime;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername;
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
