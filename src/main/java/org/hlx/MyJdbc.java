package org.hlx;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//自定义注解
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyJdbc {
    String username() default "";  //参数4个
    String pwd() default "";
    String driver() default "";
    String url() default "";
}
