package com.annotation;

import java.lang.annotation.*;
//自定义注解
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JdbcUtil {
    String url() default "";
    String driver() default "";
    String userName() default "";
    String password() default "";
}
