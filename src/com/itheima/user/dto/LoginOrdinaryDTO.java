package com.itheima.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
/**
  * 普通用户登陆时传递的邮箱密码
  *
  * @author: qinjie
 **/
public class LoginOrdinaryDTO {
    @NotBlank(message = "邮箱不能为空")
    @Email
    private String email;
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
