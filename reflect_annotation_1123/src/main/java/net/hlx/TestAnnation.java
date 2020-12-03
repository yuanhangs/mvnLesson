package net.hlx;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestAnnation {
    public static void main(String[] args) {
        try {
            //1.class对象
            //java.lang.NoSuchMethodException: net.hlx.JdbcUtil.show()
            Class<?> cl = Class.forName("net.hlx.UserJdbc");
            //2.method对象
            Method method = cl.getMethod("show");
            //3. 获得当前方法是否使用注解JdbcUtil
            boolean flag = method.isAnnotationPresent(JdbcUtil.class);
            //4.判断
            if (flag) {
                //5.通过方法获取注解
                JdbcUtil ju = method.getAnnotation(JdbcUtil.class);
                //6.获取注解4个参数
                String driver = ju.driver();
                String url = ju.url();
                String username = ju.username();
                String pwd = ju.password();

                //测试链接
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url,username,pwd);

                System.out.println(con);
                // 多个： Annotation[] ans= cl.getAnnotations();

            }else{
                System.out.println("没有注解！！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
