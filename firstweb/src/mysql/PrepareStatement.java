package mysql;

import java.sql.*;

public class PrepareStatement {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String sql = "insert into auth_admin(admin_name,password) values(?,?)";
        // test2.method(sql);
        sql = "select * from auth_admin where admin_id = ?";
        test2.method2(sql);
    }
}
class Test2{
    // 插入,删除，更新
    void method(String sql){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            // 1.创建连接
            connection = Demo.finalConnection();
            // 2.预编译SQL
            statement = connection.prepareStatement(sql);
            // 3.给参数赋值
            statement.setString(1,"ming");
            statement.setString(2,"123");
            // 4.执行SQL
            int count = statement.executeUpdate();
            System.out.println("影响了 "+count);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Demo.close(statement,connection);
        }
    }

    // 查询
    void method2(String sql){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            connection = Demo.finalConnection();
            statement = connection.prepareStatement(sql);
            // 设置输入参数
            statement.setInt(1,5);
            // 执行SQL
            rs = statement.executeQuery();

            while (rs.next()){
                String admin_name = rs.getString(2);
                System.out.println("姓名 :"+admin_name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Demo.close(statement,connection);
        }
    }
}
