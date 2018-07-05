package db;

import java.sql.*;
public class DBConn {

//    获取数据库连接
    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("org.hsqldb.jdbcDriver");
            String url="jdbc:hsqldb:hsql://localhost";
            String user = "sa";
            String pass = "";
            conn=DriverManager.getConnection(url,user,pass);//创建连接

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

//    获取PreparedStatement对象
    public static PreparedStatement prepare(Connection conn,String sql){
        PreparedStatement ps=null;
        try{
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

//    关闭数据库
    public static void close(Connection conn){
    try{
        conn.close();
        conn=null;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

//    关闭PreparedStatement
    public static void close(Statement stmt){
        try{
            stmt.close();
            stmt=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    关闭ResultSet对象
    public static void close(ResultSet rs){
        try{
            rs.close();
            rs=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
