package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @ClassName TestAnnation2
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/25
 * @Version V1.0
 **/
public class TestAnnation2 {

    public static void main(String[] args) {
        try {
            //1.获得Class对象==>使用注解TestJdbc类
            Class<?> class1 = Class.forName("com.annotation.TestJdbc");

            //2.获得Method对象 =>showConnection
            Method method = class1.getDeclaredMethod("showConnection");

            //3.获得当前方法是否使用注解JdbcUtil
            boolean flag = method.isAnnotationPresent(JdbcUtil.class);
             //判断
            if(flag){
                   //获取注解对象
                JdbcUtil  info= method.getAnnotation(JdbcUtil.class);
                //获取注解信息
                String driver = info.driver();
                String url = info.url();
                String username = info.userName();
                String pass = info.password();

                //连接对象
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url,username,pass);

                //输出
                System.out.println(con);
            }else{
                System.out.println("no!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
