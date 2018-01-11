package connectionPool.tools;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

public class MyC3P0 {
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String user = "root";
    private static String password = "root";
    private static String driverClass= "com.mysql.jdbc.Driver";
    public static void main(String[] args) throws Exception{
        /**
         * 使用xml配置文件读取c3p0方法
         * 1.需要把c3p0-config.xml文件放在src目录下,会自动查找
         */
        // 创建连接池对象
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        /*// 2.设置连接参数
        cpds.setJdbcUrl(url);
        cpds.setUser(user);
        cpds.setPassword(password);
        cpds.setDriverClass(driverClass);

        // 3.设置连接池相关参数
        cpds.setInitialPoolSize(5);
        cpds.setMaxPoolSize(10);
        cpds.setCheckoutTimeout(3000);
        cpds.setMaxPoolSize(3);*/

        // 4.获取连接
        for(int i = 1;i<=10;i++){
            Connection connection = cpds.getConnection();
            System.out.println(connection);
            connection.close();     // 本质将连接对象放回连接池
        }
    }
}
