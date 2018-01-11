package connectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

// 自行设计连接池
public class MyPool3 {
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String user = "root";
    private static String password = "root";
    private static String driverClass= "com.mysql.jdbc.Driver";

    // 存储连接对象的容器
    private static LinkedList<Connection> pool = new LinkedList();
    public static LinkedList<Connection> getPool() {
        return pool;
    }

    public static void setPool(LinkedList<Connection> pool) {
        MyPool3.pool = pool;
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
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public MyPool3(){
        // 获取连接,初始化连接对象
        for(int i = 1;i<=initCount;i++){
            pool.addLast(createConnection());
            currentCount++;
        }
    }
    // 创建连接方法
    private Connection createConnection(){
        final Connection connection;
        try {
            connection = DriverManager.getConnection(url,user,password);
            // 动态代理类方式创建Connection的代理类
            /** jdk 的api: Proxy 类
             *  创建动态代理类对象
             *  static Object newProxyInstance{
             *      ClassLoader loader;     类加载器
             *      Class<?>[] interface;   代理要实现的接口列表
             *      接口 InvocationHandler h;    指派方法调用的调用处理程序(代理完对象后,对其中方法如何处理)
             *      Object invoke(
             *          Object proxy,       代理类对象
             *          Method method,      代理类对象调用的方法
             *          Object[] args       调用代理类对象方法时传入的参数列表
             *      )
             *  }
             */
            Connection myConnection = (Connection) Proxy.newProxyInstance(
                    MyPool3.class.getClassLoader(),
                    new Class[]{Connection.class},
                    (proxy, method, args) -> {
                        // 1)重写需要重写的方法 close()
                        // 获取当前调用方法的方法名称
                        String methodName = method.getName();
                        if("close".equals(methodName)){
                            MyPool3.getPool().addLast(connection);
                            return null;
                        }else{
                            // 2) 调用原来的方法,获取返回值
                            Object value = method.invoke(connection,args);
                            // 返回结果
                            return value;
                        }
                    }
            );
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
