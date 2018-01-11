package connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

// 测试连接池对象
public class TestPool {
    public static void main(String[] args) {
        Test7 test7 = new Test7();
        // test7.method();
        test7.method2();
    }
}
class Test7{
    void method(){
        // 1.构造连接池对象
        MyPool myPool = new MyPool();
        // 2,模拟用户并发获取连接
        for (int i = 1;i<=11;i++){
            Connection connection = myPool.getConnection();
            System.out.println(connection);

            // 模拟用户释放连接
            if(i == 3){
                // 用户调用close()方法也能成功把对象放回连接池中
                MyPool.releaseConnection(connection);
            }
        }
    }

    // 使用代理模式重写Connection close 方法
    void method2(){
        // 1.构造连接池对象
        MyPool2 myPool = new MyPool2();
        // 2,模拟用户并发获取连接
        for (int i = 1;i<=11;i++){
            Connection connection = myPool.getConnection();
            System.out.println(connection);

            // 模拟用户释放连接
            if(i == 3){
                // 1.静态代理类,重写Connection 的close方法
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
