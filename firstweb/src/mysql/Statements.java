package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 使用Statement接口执行DDL语句(create drop alter)
public class Statements {
    public static void main(String[] args) {
        Test test = new Test();
        String sql = "insert into auth_admin(admin_id,admin_name,password) values(null,'aqie','123')";
        /*sql = "update auth_admin set admin_name='啊切',password='456' where admin_id=2";
        sql = "delete from auth_admin where admin_id = 1";*/
        // test.method(sql);
        sql = "select * from auth_admin";
        test.method2(sql);
    }
}

class Test{
    public void method(String sql){
        Connection connection = Demo.finalConnection();
        // 准备sql
        Statement statement = null;
        int count = 0;
        try{
            statement = connection.createStatement();
            // 执行sql
            count = statement.executeUpdate(sql);
            statement.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("影响了"+count);
    }

    public void method2(String sql){
        Connection connection = Demo.finalConnection();
        // 准备sql
        Statement statement = null;
        ResultSet rs = null;
        try{
            statement = connection.createStatement();
            // 执行sql
            rs = statement.executeQuery(sql);
            while(rs.next()){      // 返回true 代表有数据
                int id = rs.getInt(1);
                String admin_name = rs.getString(2);
                String password = rs.getString(3);
                String email = (String) rs.getObject("email");
                System.out.println(id+":"+admin_name+":"+password+":"+email);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Demo.close(rs,statement,connection);
        }

    }
}
