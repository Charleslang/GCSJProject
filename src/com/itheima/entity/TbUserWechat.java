package com.itheima.entity;


public class TbUserWechat {

  private String uWOpenid;
  private String uWProfile;
  private String uWGender;
  private String uWNickname;
  private java.sql.Date uWCreateTime;
  private Integer uWLoginTime;


  public String getUWOpenid() {
    return uWOpenid;
  }

  public void setUWOpenid(String uWOpenid) {
    this.uWOpenid = uWOpenid;
  }


  public String getUWProfile() {
    return uWProfile;
  }

  public void setUWProfile(String uWProfile) {
    this.uWProfile = uWProfile;
  }


  public String getUWGender() {
    return uWGender;
  }

  public void setUWGender(String uWGender) {
    this.uWGender = uWGender;
  }


  public String getUWNickname() {
    return uWNickname;
  }

  public void setUWNickname(String uWNickname) {
    this.uWNickname = uWNickname;
  }


  public java.sql.Date getUWCreateTime() {
    return uWCreateTime;
  }

  public void setUWCreateTime(java.sql.Date uWCreateTime) {
    this.uWCreateTime = uWCreateTime;
  }


  public Integer getUWLoginTime() {
    return uWLoginTime;
  }

  public void setUWLoginTime(Integer uWLoginTime) {
    this.uWLoginTime = uWLoginTime;
  }

}
