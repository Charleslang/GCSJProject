package com.itheima.common;

/**
  * 自定义异常类，适用于swagger的返回值说明
  *
  * @author: qinjie
 **/
public class Result<T> {
    public final static Integer SUCCESS = 200;
    public final static Integer ERROR = 500;
    public final static Integer UNAUTHORIZED = 401;
    public final static Integer FORBIDDEN = 403;
    private int code;
    private String msg;
    private T datas;
    public static Result ok(){
        return new Result(SUCCESS, "success");
    }
    public static Result getInstance(Integer code, String msg){
        return new Result(code, msg);
    }
    public static Result ok(Object datas){
        return new Result(SUCCESS, "success",datas);
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
