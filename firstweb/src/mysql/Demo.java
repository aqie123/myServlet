package mysql;

import java.sql.*;
import java.util.Properties;

public class Demo {
    // jdbc协议+数据库协议://主机地址+端口号+数据库名
    private static String url = "jdbc:mysql://localhost:3306/test";        // 连接数据库字符串
    // 用户名
    private static String user = "root";
    // 密码
    private static String password = "root";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        finalConnection();

    }

    // 3.连接数据库最终方法
    public static Connection finalConnection() {
        try{
            // 反射获取类对象
            Class.forName("com.mysql.jdbc.Driver");     // 执行Driver类静态代码块 (注册驱动)
            // 2. 驱动管理类获取连接数据库(通过url识别需要连接数据库)
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }catch(SQLException  e){
            throw new RuntimeException(e);
        }

    }

    // 2.驱动管理类连接数据库
    private static void ManagerDriverConnection() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();    // 注册一次驱动
        // Driver driver2 = new Driver
        // 1. 注册驱动程序
        DriverManager.registerDriver(driver);           // 注册两次驱动
        // 2. 获取连接数据库(通过url识别需要连接数据库)
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }

    // 1.直接使用驱动程序连接
    private static Connection connectMysql(){
        try {
            // 1,创建驱动程序的实现类对象
            Driver driver = new com.mysql.jdbc.Driver();
            Properties properties = new Properties();
            properties.setProperty("user",user);
            properties.setProperty("password",password);
            // 2.连接数据库
            return driver.connect(url,properties);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // 4. 释放资源方法
    public static void close(ResultSet rs ,Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    // 5.
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException var4) {
                var4.printStackTrace();
                throw new RuntimeException(var4);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException var3) {
                var3.printStackTrace();
                throw new RuntimeException(var3);
            }
        }

    }
}
