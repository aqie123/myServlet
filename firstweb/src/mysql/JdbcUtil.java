package mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    // jdbc协议+数据库协议://主机地址+端口号+数据库名
    private static String url = null;
    // 用户名
    private static String user = null;
    // 密码
    private static String password = null;
    // 驱动程序类
    private static String driverClass = null;

    /**
     * 只注册一次,静态代码块
     */
    static{
        // 读取 jdbc.properties
        Properties properties = new Properties();
        // 注册驱动程序
        try{
            // 构造输出流
            // 如果只是单纯项目下用这个
            // InputStream inputStream = new FileInputStream("firstweb/src/configs/jdbc.properties");

            /** 如果是Servlet web 项目不能使用相对路径
             * 1.WebServletContext.getRealPath() / getResourceAsStream
             * 2.不能使用ServletContext 读取文件
             * 3.使用类路径方式读取配置文件
             */
            Class clazz = JdbcUtil.class;
            // 使用类路径方式读取配置文件
            /**   / 代表项目的类路径的根目录
             *  java项目 类路径根目录：执行项目的bin目录
             *  web项目 ： 指向 firstweb/web/WEB-INF/classes
             */

            InputStream inputStream = clazz.getResourceAsStream("/configs/jdbc.properties");
            properties.load(inputStream);
            // 加载文件
            properties.load(inputStream);
            // 读取文件内容
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driverClass = properties.getProperty("driverClass");
            System.out.println(url);
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据库连接通用方法
     * @return
     */
    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 释放资源
    public static void close(ResultSet rs , Statement stmt, Connection conn){
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

    private static DataSource ds = new ComboPooledDataSource();
    public static DataSource getDataSource(){
        DataSource ds = new ComboPooledDataSource();
        return ds;
    }
}
