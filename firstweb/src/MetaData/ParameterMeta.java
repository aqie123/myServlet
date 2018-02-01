package MetaData;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import base.entity.Student;
import libs.WebUtil;

import java.sql.*;
import java.util.List;

// 参数元数据
public class ParameterMeta {
    public static void main(String[] args) throws SQLException {
        // parameMethod();
        // 通用的更新方法
        String sql = null;
        Object[] values = null;
        /*
        *//*sql="update student set name=?,gender=?,score=?,birth=? where id=?";
        values  = new Object[]{"啊切233",0,66.50,"2018-01-12",2};*//*
        sql = "insert into student(id,name,gender,score,birth) values(?,?,?,?,?)";
        values = new Object[]{5,"aqie2",0,66.50,"2018-01-12"};
        WebUtil.updateData(sql,values);*/
        // queryData();
        // 通用的查询方法
        sql = "select * from student";
        List<Student>  studentList = WebUtil.queryData(sql,null,Student.class);
        // 遍历list
        for(Student student : studentList){
            System.out.println(student);
        }
    }

    // 获取预编译有几个参数,遍历数组赋值
    private static void parameMethod() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection connection = cpds.getConnection();
        String sql = "insert into student(id,name,gender,score,birth) values(?,?,?,?,?)";
        // 预编译
        PreparedStatement pstmt = connection.prepareStatement(sql);
        // 知道预编译有几个参数
        ParameterMetaData pm = pstmt.getParameterMetaData();
        int countParam = pm.getParameterCount();
        System.out.println(countParam);
        // 新的赋值方式
        // 参数值放入数组
        Object[] values = new Object[]{2,"aqie2",0,66.50,"2018-01-12"};
        for(int i = 1;i<=countParam;i++){
            pstmt.setObject(i,values[i-1]);
        }
        // 参数赋值
        /*pstmt.setInt(1,1);
        pstmt.setString(2,"aqie");
        pstmt.setInt(3,1);
        pstmt.setDouble(4,88.05);
        pstmt.setString(5,"2018-01-12");*/
        pstmt.executeUpdate();
    }

    // 查询方法
    public static void queryData() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection connection = cpds.getConnection();
        String sql = "select * from student";
        // 预编译
        PreparedStatement pstmt = connection.prepareStatement(sql);
        // 知道预编译有几个参数
        ParameterMetaData pm = pstmt.getParameterMetaData();
        int countParam = pm.getParameterCount();
        System.out.println(countParam);
        Object[] values = null; // new Object[]{2};
        if(values != null){
            for(int i = 1;i<=countParam;i++){
                pstmt.setObject(i,values[i-1]);
            }
        }
        ResultSet resultSet = pstmt.executeQuery();
        // 遍历set结果集 显示结果
        /*while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String gender = resultSet.getString(3);
            String score = resultSet.getString(4);
            String birth = resultSet.getString(5);
            System.out.println(id+" : "+name+" : "+gender+" : "+score+" : "+birth);
        }*/
        // 得到结果集元数据
        ResultSetMetaData rsmd = resultSet.getMetaData();
        // 得到列数量
        int column = rsmd.getColumnCount();
        System.out.println("列数量 ："+column);
        while(resultSet.next()){
            for(int i = 1;i<=column;i++){
                Object value = resultSet.getObject(i);
                System.out.println(value);
            }
        }

    }
}

