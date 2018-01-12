package libs;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import entity.Contact;
import entity.Student;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebUtil {
    // 接收request参数直接封装到对象中去
    public static <T>T copyRequestToBean(HttpServletRequest req,Class<T> clazz){
        // 1.得到request的所有参数
        Map map = req.getParameterMap();
        // 2.参数名称要和javabean的属性一致
        try {
            // 构造对象
            T t = clazz.newInstance();
            BeanUtils.copyProperties(t,map);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // mysql 通用的更新/插入方法
    public static void updateData(String sql,Object[] values){
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection connection = null;
        try {
            connection = cpds.getConnection();
            // 预编译
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ParameterMetaData pm = pstmt.getParameterMetaData();
            int countParam = pm.getParameterCount();
            System.out.println(countParam);
            // 新的赋值方式
            for(int i = 1;i<=countParam;i++){
                pstmt.setObject(i,values[i-1]);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * mysql 通用的查询方法
     * 传入查询语句,
     * 返回对应的List集合
     */
    public static <T>List<T> queryData(String sql,Object[] values,Class<T> clazz){
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection connection = null;
        List studentList = new ArrayList<>();
        try {
            connection = cpds.getConnection();
            // 预编译
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // 知道预编译有几个参数
            ParameterMetaData pm = pstmt.getParameterMetaData();
            int countParam = pm.getParameterCount();
            System.out.println(countParam);

            // 如果是null,则不赋值
            if(values != null){
                for(int i = 1;i<=countParam;i++){
                    pstmt.setObject(i,values[i-1]);
                }
            }
            ResultSet resultSet = pstmt.executeQuery();
            // 得到结果集元数据
            ResultSetMetaData rsmd = resultSet.getMetaData();
            // 得到列数量
            int column = rsmd.getColumnCount();
            System.out.println("列数量 ："+column);
            while(resultSet.next()){
                // 每一行数据就是一个对象,构建对象
                Object obj = clazz.newInstance();
                for(int i = 1;i<=column;i++){
                    Object value = resultSet.getObject(i);
                    // 通过结果集元数据得到字段名称
                    String columnName = rsmd.getColumnName(i);
                    // 表中每列数据封装到对象中(约定前提：表中字段名称和Javabean中相同)
                    // 把值拷贝到javabean对象中
                    BeanUtils.copyProperty(obj,columnName,value);
                }
                studentList.add(obj);
            }
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
