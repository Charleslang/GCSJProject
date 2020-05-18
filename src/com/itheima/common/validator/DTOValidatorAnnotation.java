package com.itheima.common.validator;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
  * 用于标识需要进行DTO判断的方法
  *
  * @author: qinjie
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DTOValidatorAnnotation {
}
