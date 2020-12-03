package com.annotation;

import java.lang.reflect.Method;

/**
 * @ClassName TestJdbc
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/25
 * @Version V1.0
 **/
public class TestJdbc {
    @JdbcUtil(driver = "com.mysql.cj.jdbc.Driver",url = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC",userName = "root",password = "root")
    public void showConnection(){
    }
}

