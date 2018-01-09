package mysql;

import java.sql.*;

public class CallableStatement {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        String sql = "CALL pro_test(?)";
        // test3.method(sql);
        test3.method3();
    }
}

// 执行带有参数的存储过程
class Test3{
    void method(String sql){
        Connection connection = null;
        java.sql.CallableStatement statement = null;
        ResultSet rs = null;
        try{
            // 1.准备连接
            connection = Demo.finalConnection();
            // 2.预编译sql
            statement = connection.prepareCall(sql);
            // 3. 参数赋值
            statement.setInt(1,2);
            // 4.设置输出参数
            // statement.registerOutParameter(1, Types.VARCHAR);
            // 5. 执行SQL
            rs = statement.executeQuery();
            /*String name = rs.getString(2);  // 与步骤四数字一致,存储过程
            System.out.println(name);*/
            // 6. 遍历结果集
            while (rs.next()){
                System.out.println(rs.getString("admin_name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            Demo.close(statement,connection);
        }
    }

    void method2(){
        boolean rel= Statement.class.isAssignableFrom(PreparedStatement.class);
        boolean rel2= Statement.class.isAssignableFrom(java.sql.CallableStatement.class);
        System.out.println(rel+":"+rel2);
    }

    void method3(){
        JdbcUtil jdbcUtil = new JdbcUtil();
    }
}

/*
    DELIMITER $
    CREATE PROCEDURE pro_test(IN sid INT,OUT sname VARCHAR(20))
    BEGIN
        select admin_name INTO sname from auth_admin where admin_id = sid;
    END $

    DELIMITER $
    CREATE PROCEDURE pro_test(IN sid INT)
    BEGIN
        select * from auth_admin where admin_id = sid;
    END $


    CALL pro_test(2,@sname);
    CALL pro_test(2);

    drop procedure if exists pro_test;  // 删除存储过程
 */
