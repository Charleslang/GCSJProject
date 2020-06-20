package com.itheima.pay.service;

import java.util.Map;

public interface AlipayService {

    /**
     * 用于支付宝支付业务的入参 app_id。
     */
    String APPID = "2016101200667109";

    /**
     * 用于支付宝账户登录授权业务的入参 pid。
     */
    String PID = "2088102179202860";

    /**
     * 用于支付宝账户登录授权业务的入参 target_id。
     */
    String TARGET_ID = "";

    /**
     * 用于支付宝异步通知支付结果的入参 notify_url。
     */
    String NOTIFY_URL = "http://101.200.166.167/GCSJProject/alipay/callback";

    /**
     *  pkcs8 格式的商户私钥。
     *
     * 	如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个，如果两个都设置了，将优先
     * 	使用 RSA2_PRIVATE。
     */
    String RSA2_PRIVATE = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCL37SZI545lIL7jcKi6NhK8ytNaoA/yQiSmPWAdy5zDSLY8KOV0xVEHvEfME1HIYD9AwNCH8secDBKS2SUQbUb6+aqZYrtdyQ79n40Rz8QJkFLgkoJ7ReCmbbUbcqoi8ScbFfaYVumSTj5EYh/Ut2ETcReRwGcYtrJvhmJVuUdAX63RPPYLDr8k1aBZE81cyuqI1tGvnhqC7ouHdCddbdvpc7pyuw5UqwahktL/b4d/VDizietHBi2h2yxImHFtdPZx0iNJfYk5LJlaeDmph3lQNNDg7CPbuF+qXE6WL2hsCGxwVavXl2KUIBjowJxBLtFvpvasnaACKHaD5J1FbLxAgMBAAECggEAQ71cXknkp+gnoyIdX/46OdoYX46ze7CliTGwu718blWvSbcI0ld+1hXSGpOu6ULtkBr0agKxwRT+HgzzMeW8i0As3tr8dFKd5rhSmIjknrKYLrRznOkI2MQOykQ9wHCoEEVcKrO5ygduIxl9rIP6Kcfr0Oi8e/tYEBoTjfLaVLgVYTq8f56tRWfKTFJlHvt0FKMVUuYanvYL4X1wgWbpVBR6WnFksQmKRv+ex2Xp3M6ZqA0I1UwU6jbMRd4RuDZ+jouCs+uLIe7jg+TlUQFx7EskhNiBRirQa7TMZ8CDX/Ojv2ujBreMnkr1nHYj49puXqORbFYuiCPhFwlgINopvQKBgQD5EhqdX4mo3HnCyoaVC9JQuIUMxpmEupUDOj8IgiK1mc4HPxL9sYfPn8wPshkzRcLH135sJJf7MdoVlxplwjlZ8JCHvEsopi3TRsHzENiidYd0kWS1b+3lF888evoT/cb4ylvfY4JeYSDQMzHVgp/Ab3o7+6hnB4pi7e+aIZlL8wKBgQCPw+UkwkhGc5afj+L7hlLkDrPJQQB9h3faa+9ZTNxm5lKmkMXcO9fWKNgswHtg56FtRLfYvq/EAHT9HUl5UDbezju4PxqcWKbXWqmAC2K3R1JxpHUXHz66lKweA4KcYFoEyOmi7euqdIxfesUzuQEhtJfKVRPDvxkEsCTZNuwyiwKBgGLfbPFMG7mMzEknXIWOS87/cNHBhO/LoZvGY39dKaothDwcLc3Hy8IADWGtsZNI/imWwfjsDekJwSkQ8smycFHjzXwUo0FftpFIZXW4GkdjoIIFtZTQ+f8XlIzNxLhq5bGdoxrqxbXxmLUNnZrEX+ZkWoG1RQShWa4sBhGJhPFBAoGBAIBZtmQhCAHOBHWkMlO40pxE/AH7hIKNxVU988xYMJW1n6iRq/Q5gTLz+DvMBNq5MYeqSDC73ZQxjEDGOuiR0ssMeIi/3fQjuaCekqF8iL90b4iB+P+Rp6FQRnHtVFhkNTn8XYpWu4XM094Sb6kDzJzY7IN5fVHPdHiZAezjefCNAoGBAOeOSXOjUMFWoVlo/YFvw7oTg7E6UhMEi3NLPzaykaS15d6+WVE4rq43RYAWG5nwOcjNIoCncKBjZ6U4uqDrQmCiZ/qKK5xPE0ZrG+EtP8sNlgdRWHiao8QfH7ctMVzSdNJWboM7on1UEg/6m2awsSe5ctLxGKFZTuAac4XAfsJa";

    /**
     * 支付宝公钥，用于异步通知支付结果验证签名。
     */
    String PUBLICKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8OSkBbJlZk0IJVb61nHI5BLdfD66RoU9xiD0/GWsaczubyvbveTW3xG7KsRNmfY+MQ4BNMywrOkfIRqgOrYQYKYi0QvDcetch/LJgJ2aK4S+vwoU0qFTRnvkWzxIZWrRVlnIBvIIZSKJEq5XtK7xjOz0PeCTWGAOXE5zZtl8hZMBHq2JBdiO+KBnrgaea8PAypL8JR9zxdOHUcFnFuKf9AQVgsMx8zaZEuHRsqQYbpO9zw2yIlFH3ztUlnLTsYpYgd1AafDWGFy5lw1ESCma23PQWyz0feg15xPOgRSMI4frMVhb1Ly8Yi6oxB+n1LhRE522HyK8QsZGHMY5iZTd0wIDAQAB";

    String alipay(Integer orderNo);

    String updateOrderInfo(Map<String, String> map);
}
