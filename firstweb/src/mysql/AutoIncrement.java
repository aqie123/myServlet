package mysql;

import java.sql.*;

public class AutoIncrement {
    public static void main(String[] args) {
        Test6 test6 = new Test6();
        test6.method();
    }
}

class Test6{
    void method(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = JdbcUtil.getConnection();
            // 同时插入一个部门和该部门所在员工的数据
            String departmentSql = "insert into department(name) values(?)";
            String employeeSql = "insert into employee(name,dpID) values(?,?)";
            statement = connection.prepareStatement(departmentSql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,"DesignDepartment");
            statement.executeUpdate();
            // 获取自增长的值
            resultSet = statement.getGeneratedKeys();
            int dpID = 0;
            while (resultSet.next()){
                dpID = resultSet.getInt(1);
            }
            System.out.println("插入自增长值为 ："+dpID);

            statement = connection.prepareStatement(employeeSql);
            statement.setString(1,"ming");
            statement.setInt(2,3);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}