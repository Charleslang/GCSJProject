package com.itheima.user.dto;

public class LoginQQDTO {
    /**
     * 鉴权token
     */
    private String access_token;
    /**
     * 唯一标识用户，通qq号对应
     */
    private String openid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
