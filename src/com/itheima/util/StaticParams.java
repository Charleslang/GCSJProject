package com.itheima.util;

public class StaticParams {
    public final static String DEFAULT_PROFILE="https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3256100974,305075936&fm=26&gp=0.jpg";
    /**
     * token有效期，单位秒
     */
    public final static Integer TOKEN_VALIDITY = 3600;
    /**
     * 错误状态码
     */
    public final static Integer ERROR_CODE = 500;
    /**
     * 正确状态码
     */
    public final static Integer SUCCESS_CODE = 200;
    /**
     * 文件保存在服务器上的绝对地址
     */
    public final static String DEFAULT_IMAGE_SAVE_PATH_REAL = "G://";
    /**
     * 访问图片的http地址
     */
    public final static String DEFAULT_IMAGE_SAVE_PATH_NETWORK = "http://localhost:8080/CampusShops/";
}
