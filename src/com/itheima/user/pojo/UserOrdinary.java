package com.itheima.user.pojo;

import java.io.Serializable;

/**
  * 普通用户
  *
  * @author: qinjie
 **/
public class UserOrdinary implements User, Serializable {
    /**
     * 用户id
     */
    private Integer mUserId;
    /**
     * 昵称
     */
    private String mNickname;
    /**
     * token
     */
    private String mToken;
    /**
     * 邮箱
     */
    private String mEmail;
    /**
     * 邮箱
     */
    private String mGender;
    /**
     * 头像
     */
    private String mProfile;

    public Integer getmUserId() {
        return mUserId;
    }

    public void setmUserId(Integer mUserId) {
        this.mUserId = mUserId;
    }

    public String getmNickname() {
        return mNickname;
    }

    public void setmNickname(String mNickname) {
        this.mNickname = mNickname;
    }

    @Override
    public String getmToken() {
        return mToken;
    }
    @Override
    public void setmToken(String mToken) {
        this.mToken = mToken;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
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

    public UserOrdinary(Integer mUserId, String mNickname, String mToken, String mEmail, String mGender, String mProfile) {
        this.mUserId = mUserId;
        this.mNickname = mNickname;
        this.mToken = mToken;
        this.mEmail = mEmail;
        this.mGender = mGender;
        this.mProfile = mProfile;
    }

    @Override
    public String toString() {
        return "UserOrdinary{" +
                "mUserId=" + mUserId +
                ", mNickname='" + mNickname + '\'' +
                ", mToken='" + mToken + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mGender='" + mGender + '\'' +
                ", mProfile='" + mProfile + '\'' +
                '}';
    }
}
