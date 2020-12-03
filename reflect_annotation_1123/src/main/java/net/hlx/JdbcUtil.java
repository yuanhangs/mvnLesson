package net.hlx;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JdbcUtil {  // 4个字段
    String driver() default "";
    String url() default "";
    String username() default "";
    String password() default "";
}
