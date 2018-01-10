package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// jdbc 验证事务
public class Transaction {
    public static void main(String[] args) throws SQLException {
        Test7 test7 = new Test7();
        test7.method();
    }
}

class Test7{
    void method() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getConnection();
            // 关闭自动提交功能
            connection.setAutoCommit(false);  // 数据库执行 set autocommit=0;

            String delSql = "update account set deposit = deposit - 2000 where name = ?";
            statement = connection.prepareStatement(delSql);
            statement.setString(1,"aqie");
            statement.executeUpdate();

            // 出现异常
            // int i = 1/0;

            String addSql = "update account set deposit = deposit + 2000 where name = ?";
            statement = connection.prepareStatement(addSql);
            statement.setString(1,"bqie");
            statement.executeUpdate();
            // 当所有sql执行完成，提交事务
            connection.commit();
            System.out.println("转账成功");
        } catch (SQLException e) {
            e.printStackTrace();
            // 出现异常
            connection.rollback();
        }finally {
            JdbcUtil.close(statement,connection);
        }
    }
}
