package com.itheima.common.validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
  * 基于切面的拦截器，拦截指定的方法
  *
  * @author: qinjie
 **/
@Component
@Aspect
public class AopValidator {
    //    private static Logger logger = LogManager.getLogger(RedisAop.class);
    @Pointcut("@annotation(com.itheima.common.validator.DTOValidatorAnnotation)")
    public void InterceptController(){}

    /**环绕通知*/
    @Around(value = "InterceptController()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        Object obj[] = proceedingJoinPoint.getArgs();
        for(int i = 0; i < obj.length; i++){
            DTOValidator.validate(obj[i]);
        }
        //返回执行目标方法，并且把转换修改后的参数值传递下去
        return proceedingJoinPoint.proceed();
    }
    /**
     * 功能描述: 拦截扫描所以添加DTOValidatorAnnotation注解的方法，进行DTO的参数判断
     * @return void
     */
    @Pointcut("@annotation(com.itheima.common.validator.ParamNotNull)")
    public void InterceptController1(){}
    /**
     * 功能描述: aop拦截扫描相关包下面的NotNull注解进行判断Integer不能为null，String不能为""或null
     * @return java.lang.Object
     */
    @Around("InterceptController1()")
    public Object Around1(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] params = joinPoint.getArgs();
        if(params.length == 0){
            return joinPoint.proceed();
        }

        //获取方法，此处可将signature强转为MethodSignature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //变量类型
        Class[] patameterTypes  = signature.getParameterTypes();
        String[] patameterNames = signature.getParameterNames();
        //参数注解，1维是参数，2维是注解
        Annotation[][] annotations = method.getParameterAnnotations();
        for(int i = 0;i < annotations.length; i++){
            if(annotations[i].length != 0){
                //代表存在注解
                if(patameterTypes[i] == Integer.class){
                    //代表参数中是Integer，需要判断不为null
                    if(params[i]==null){
                        throw new ValidationException(patameterNames[i]+"参数不能为空");
                    }
                }
                else if(patameterTypes[i] == String.class){
                    //代表参数中是String，需要判断不为null,并且长度不为0
                    if(params[i]==null || (params[i]+"").length()==0){
                        throw new ValidationException(patameterNames[i]+"参数不能为空(长度不能为0)");
                    }
                }
            }
        }
        return joinPoint.proceed();
    }

}
