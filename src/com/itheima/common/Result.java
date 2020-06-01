package com.itheima.common;

import static com.itheima.util.StaticParams.ERROR_CODE;
import static com.itheima.util.StaticParams.SUCCESS_CODE;

/**
  * 自定义异常类，适用于swagger的返回值说明
  *
  * @author: qinjie
 **/
public class Result<T> {
    private int code;
    private String msg;
    private T datas;
    public static Result ok(){
        return new Result(SUCCESS_CODE, "success");
    }
    public static Result error(Integer code, String msg){
        return new Result(code, msg);
    }
    public static Result error( String msg){
        return new Result(ERROR_CODE, msg);
    }
    public static Result ok(Object datas){
        return new Result(SUCCESS_CODE, "success",datas);
    }
    public Result(int code, String msg, T datas) {
        this.code = code;
        this.msg = msg;
        this.datas = datas;
    }

    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
}
