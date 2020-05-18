package com.itheima.common.validator;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * 对象验证器
 *
 * Created by Albert on 18/1/25.
 */
public class DTOValidator {

    public static <T> void validate(T object) {
        //获得验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        //执行验证
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        //如果有验证信息，则取出来包装成异常返回
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return;
        }
        throw new ValidationException(convertErrorMsg(constraintViolations));
    }

    /**
     * 转换异常信息
     * @param set
     * @param <T>
     * @return
     */
    private static <T> String convertErrorMsg(Set<ConstraintViolation<T>> set) {
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<T> cv : set) {
            //这里循环获取错误信息，可以自定义格式
            sb.append(cv.getMessage()+" ");
        }
        return sb.toString();
    }
}
