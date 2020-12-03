package net.hlx;

public class UserJdbc {
//    @Deprecated
    @JdbcUtil(driver = "com.mysql.cj.jdbc.Driver",url = "jdbc:mysql://localhost:3306/mysql",username = "root" ,password = "root")
    public void show(){
    }
}
