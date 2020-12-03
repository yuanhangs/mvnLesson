package util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: hlx
 * @Date: 2019/10/16 
 */
public class BaseDao {
    protected Connection con ;
    protected PreparedStatement ps ;
    protected ResultSet rs;

    //声明常量
    private static  final String  DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/myschool";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";

    /**
     * 连接方法
     * @return
     */
    public Connection getConnection(){
        //1.加载驱动
        try {
            Class.forName(DRIVER);
            //2.连接对象
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取数据连接驱动
     * @return
     * @throws Exception
     */
    public Connection getConn() throws Exception{
        //1、加载数据库驱动
        Class.forName(DRIVER);
        //2、连接数据库（需要用户名和密码以及数据库服务器连接地址）
        //通过连接数据库产生连接数据库的连接对象
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }

    /**
     * 释放资源
     * @param conn
     * @param ps
     * @param rs
     */
    public void releaseAll(Connection conn, PreparedStatement ps, ResultSet rs){
        //6、释放资源
       releaseTwo(conn,ps);
        try {
            if(rs !=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //释放资源
    public void releaseTwo(Connection conn,PreparedStatement ps){
        try {
            if(ps !=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //更新数据
    public int QueryUpdate(String sql,Object[] params){
        int n=0;
        try {
            PreparedStatement ps=getConnection().prepareStatement(sql);
            for (int i = 0; i <params.length ; i++) {
                ps.setObject(i+1,params[i]);
            }
            n=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    //查询数据
    public ResultSet queryQuery(String sql,Object[]params){
        ResultSet rs=null;
        try {
            PreparedStatement ps=getConnection().prepareStatement(sql);
            for (int i = 0; i <params.length ; i++) {
                ps.setObject(i+1,params[i]);
            }
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //通过反射机制查询单条记录
    public <T>T findSimpleReResult(String sql,Object[] params,Class<T> cls) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        T resultObject=cls.newInstance();  //得到实例
        //查询数据
        ResultSet rs=this.queryQuery(sql,params);
        ResultSetMetaData metaData=rs.getMetaData();
        int colLen=metaData.getColumnCount();  //获取列数
        while(rs.next()){
            for (int i = 0; i <colLen ; i++) {
                //获取数据库列名称
                String colsName=metaData.getColumnName(i+1);
                Object colsValue=rs.getObject(colsName);
                Field field=cls.getDeclaredField(colsName);
                field.setAccessible(true);
                field.set(resultObject,colsValue);
            }

        }
        return resultObject;
    }

    //通过反射机制查询多条记录
    public <T> List<T> findMoreReResult(String sql, Object[]params,  Class<T> cls) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        List<T> list=new ArrayList<>();
        //查询数据
        ResultSet rs=this.queryQuery(sql,params);
        ResultSetMetaData metaData=rs.getMetaData();
        int colLen=metaData.getColumnCount();  //获取列数
        while(rs.next()){
            T resultObject=cls.newInstance();  //得到实例
            for (int i = 0; i <colLen ; i++) {
                //获取数据库列名称
                String colsName=metaData.getColumnName(i+1);
                Object colsValue=rs.getObject(colsName);
                Field field=cls.getDeclaredField(colsName);
                field.setAccessible(true);
                field.set(resultObject,colsValue);
            }
            list.add(resultObject);
        }
        return list;
    }
}
