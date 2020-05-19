package com.itheima.user.pojo;

import java.io.Serializable;

/**
  * qq用户实体类
  *
  * @author: qinjie
 **/
public class UserQQ implements User, Serializable {
    /**
     * 昵称
     */
    private String mNickname;
    /**
     * 性别
     */
    private String mGender;
    /**
     * 头像
     */
    private String mProfile;
    /**
     * 授权token
     */
    private String mToken;
    /**
     * openid
     */
    private String mOpenid;

    public String getmOpenid() {
        return mOpenid;
    }

    public void setmOpenid(String mOpenid) {
        this.mOpenid = mOpenid;
    }

    public String getmNickname() {
        return mNickname;
    }

    public void setmNickname(String mNickname) {
        this.mNickname = mNickname;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public String getmProfile() {
        return mProfile;
    }

    public void setmProfile(String mProfile) {
        this.mProfile = mProfile;
    }

    public String getmToken() {
        return mToken;
    }

    public void setmToken(String mToken) {
        this.mToken = mToken;
    }
}
