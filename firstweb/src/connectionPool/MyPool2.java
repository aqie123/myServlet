package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

// 自行设计连接池
public class MyPool2 {

    // 存储连接对象的容器
    private static LinkedList<Connection> pool = new LinkedList();

    public static LinkedList<Connection> getPool() {
        return pool;
    }

    public static void setPool(LinkedList<Connection> pool) {
        MyPool2.pool = pool;
    }

    // 连接池的初始化连接数
    private int initCount = 5;
    // 连接池最大连接数
    private int maxCount = 10;
    // 记录当前总的连接数
    private int currentCount = 0;
    static {
        // 注册驱动
        try {
            String driverClass = "com.mysql.jdbc.Driver";
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public MyPool2(){
        // 获取连接,初始化连接对象
        for(int i = 1;i<=initCount;i++){
            pool.addLast(createConnection());
            currentCount++;
        }
    }
    // 创建连接方法
    private Connection createConnection(){
        Connection connection;
        try {
            // 原来真实连接对象
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            // 创建connection静态代理类
            MyConnection myConnection = new MyConnection(connection);
            return myConnection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 对外提供给java程序获取连接的方法
    public Connection getConnection(){
        // 从容器中取出连接对象返回给java程序
        // 1) 并发连接数小于5,才从池中取出
        if(pool.size()>0){
            return pool.removeFirst();
        }
        // 2) 并发数量超过初始化连接数,程序自动获取连接对象,超过最大连接数不能获取
        if(currentCount<maxCount){
            System.out.println("超过初始化连接数");
            currentCount++;
            return createConnection();
        }
        // 3) 超过最大连接数
        throw new RuntimeException("已经超过最大连接数");
    }

    // 对外提供释放连接对象的方法
    public static void releaseConnection(Connection connection){
        // 放回连接池容器中
        pool.addLast(connection);
    }
}
