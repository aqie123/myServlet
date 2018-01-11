package connectionPool.tools;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MyDBCP {
    /*private static String url = "jdbc:mysql://localhost:3306/test";
    private static String user = "root";
    private static String password = "root";
    private static String driverClass= "com.mysql.jdbc.Driver";*/
    public static void main(String[] args) throws Exception {

        // BasicDataSource bds = new BasicDataSource();
        // 1.使用工厂类创建dbcp连接池对象,读取配置文件
        Properties properties = new Properties();
        // 使用类路径读取配置文件
        InputStream in = MyDBCP.class.getResourceAsStream("/connectionPool/tools/jdbc.properties");
        // 加载配置文件
        properties.load(in);

        /**
         * dbcp 可以自动识别配置信息,配置文件key名称和设置方法一致
         */
        // 2.设置连接参数
        /*bds.setUrl(url);
        bds.setUsername(user);
        bds.setPassword(password);
        bds.setDriverClassName(driverClass);
        // 3.设置连接池参数
        bds.setInitialSize(5);       // 初始化连接数
        bds.setMaxActive(10);       // 设置最大连接数
        bds.setMaxWait(3000);       // 超过最大连接数时,最大等待时间为3秒*/
        // 4.获取连接
        // 从连接池获取连接
        Connection connection = null;
        try {
            BasicDataSource bds = (BasicDataSource) BasicDataSourceFactory.createDataSource(properties);
            for(int i = 0;i<=11;i++){
                connection = bds.getConnection();
                System.out.println(connection);
                // 注意释放连接
                // connection.close(); // 连接对象放回连接池中,使连接池保存最大连接数
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
