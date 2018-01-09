package mysql;

import javax.sql.rowset.JdbcRowSet;
import java.sql.*;

// 使用Statement接口执行DDL语句(create drop alter)
public class Statements {
    public static void main(String[] args) {
        Test test = new Test();
        String sql = "insert into auth_admin(admin_name,password) values('aqie','123')";
        /*sql = "update auth_admin set admin_name='啊切',password='456' where admin_id=2";
        sql = "delete from auth_admin where admin_id = 1";*/
        // test.method(sql);
        // sql = "select * from auth_admin";
        // test.method2(sql);
        // test.testStatement(sql);
        long start = System.currentTimeMillis();
        test.testBatchStatement(sql);
        long end = System.currentTimeMillis();
        System.out.println("耗时为： "+(end-start));
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

    public void testStatement(String sql){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            for(int i = 0;i<2000;i++){
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(statement,connection);
        }
    }

    public void testBatchStatement(String sql){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            for(int i = 0;i<2000;i++){
                // sql 加入缓存区
                statement.addBatch(sql);
                // 每20条发送SQL
                if(i%20 == 0){
                    // 执行SQL语句
                    statement.executeBatch();
                    // 清空缓冲区
                    statement.clearBatch();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(statement,connection);
        }
    }

    public void testBatchPreparedStatement(String sql){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql);
            for(int i = 0;i<=2000;i++){
                // 参数赋值
                statement.setString(1,"aqie");
                statement.setString(2,"123");
                // sql 加入缓存区
                statement.addBatch();
                // 每20条发送SQL
                if(i%20 == 0){
                    // 执行SQL语句
                    statement.executeBatch();
                    // 清空缓冲区
                    statement.clearBatch();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(statement,connection);
        }
    }
}
