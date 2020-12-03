package org.hlx;

public class UserJdbc {

    @MyJdbc(username = "root",pwd="root",driver = "com.mysql.cj.jdbc.Driver",url = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC")
    public void show(){

    }
}
