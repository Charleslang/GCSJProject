package com.itheima.user.dto;

import javax.validation.constraints.NotBlank;

public class LoginQQDTO {
    /**
     * 鉴权token
     */
    @NotBlank(message = "昵称不能为空")
    private String nickname;
    /**
     * 唯一标识用户，通qq号对应
     */
    @NotBlank(message = "openid不能为空")
    private String openid;
    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空")
    private String gender;
    /**
     * 头像
     */
    @NotBlank(message = "头像不能为空")
    private String profile;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
