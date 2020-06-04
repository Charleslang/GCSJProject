package com.itheima.entity;


import java.sql.Date;

public class TbAddress {

  private Integer aId;
  private String aDetails;
  private String aPhone;
  private java.sql.Date aCreateTime;
  private String aUserId;
  private Integer aUserDefault;
  private String aUsername;


  public Integer getaId() {
    return aId;
  }

  public void setaId(Integer aId) {
    this.aId = aId;
  }

  public String getaDetails() {
    return aDetails;
  }

  public void setaDetails(String aDetails) {
    this.aDetails = aDetails;
  }

  public String getaPhone() {
    return aPhone;
  }

  public void setaPhone(String aPhone) {
    this.aPhone = aPhone;
  }

  public Date getaCreateTime() {
    return aCreateTime;
  }

  public void setaCreateTime(Date aCreateTime) {
    this.aCreateTime = aCreateTime;
  }

  public String getaUserId() {
    return aUserId;
  }

  public void setaUserId(String aUserId) {
    this.aUserId = aUserId;
  }

  public Integer getaUserDefault() {
    return aUserDefault;
  }

  public void setaUserDefault(Integer aUserDefault) {
    this.aUserDefault = aUserDefault;
  }

  public String getaUsername() {
    return aUsername;
  }

  public void setaUsername(String aUsername) {
    this.aUsername = aUsername;
  }
}
