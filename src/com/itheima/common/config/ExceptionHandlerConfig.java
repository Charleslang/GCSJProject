package com.itheima.common.config;

import com.itheima.common.RRException;
import com.itheima.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.naming.AuthenticationException;
import javax.validation.ValidationException;

/**
 * 自定义状态码返回前端
 *
 * @author LiangYongjie
 */
@RestControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        System.out.println(e.getMessage());
        return Result.error(500, "未知异常");
    }
    @ExceptionHandler(RRException.class)
    public Result handlerException(RRException e) {
        e.printStackTrace();
        return Result.error(500, e.getMsg());
    }
@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result handlerException(HttpRequestMethodNotSupportedException e) {
        e.printStackTrace();
        return Result.error(500, "请求方式错误");
    }
    @ExceptionHandler(ValidationException.class)
    public Result handlerException(ValidationException e) {
        e.printStackTrace();
        return Result.error(500, e.getMessage());
    }

}
