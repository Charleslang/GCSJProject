package com.itheima.entity;


import java.sql.Date;

public class TbAddress {

  private Integer aId;
  private String aDetails;
  private String aUniversity;
  private java.sql.Date aCreateTime;
  private String aUserId;
  private Integer aUserDefault;

  public Integer getaUserDefault() {
    return aUserDefault;
  }

  public void setaUserDefault(Integer aUserDefault) {
    this.aUserDefault = aUserDefault;
  }

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

  public String getaUniversity() {
    return aUniversity;
  }

  public void setaUniversity(String aUniversity) {
    this.aUniversity = aUniversity;
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

}
