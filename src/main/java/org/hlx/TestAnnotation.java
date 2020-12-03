package org.hlx;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestAnnotation {

    public static void main(String[] args) {
        try {
            //1.获得Class对象==>使用注解TestJdbc类
            Class<?> class1 = Class.forName("org.hlx.UserJdbc");

            //2. method object
            Method method =class1.getMethod("show");

            //3.获得当前方法是否使用注解JdbcUtil
            boolean flag= method.isAnnotationPresent(MyJdbc.class);

            //4.判断
            if(flag){
                //获取注解对象
                MyJdbc jdbc =method.getAnnotation(MyJdbc.class);
                //获取注解信息
                String driver = jdbc.driver();
                String url = jdbc.url();
                String uname = jdbc.username();
                String pwd = jdbc.pwd();
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url,uname,pwd);
                System.out.println(con);
            }else{
                System.out.println("NO!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}