package MetaData;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import entity.Student;
import libs.WebUtil;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;

public class MyDbutils {
    public static void main(String[] args) throws SQLException {
        BasicDataSource bds = null;
        ComboPooledDataSource cpds = null;
        String sql = null;
        /**
         * DateSource接口是jdbc接口,所有第三方连接池工具获取连接接口
         */
        // 1.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        // 2.执行更新
        /*sql = "insert into student(id,name,gender) values(?,?,?)";
        updateStudent(queryRunner,sql);*/
        sql = "select * from student";

        // 3.执行查询所有学生
        /**
         *
         * ArrayHandler 类
         */
        // queryStudents(sql, queryRunner);
        sql = "select * from student where id=?";
        selectStudentByID(sql, queryRunner);

        sql = "select * from student";
        // 查询所有学生,封装到javabean中
        selectStudents(sql, queryRunner);
        sql = "select count(*) from student";
        // 查询数据总数
        selectCount(sql, queryRunner);
    }

    // ScalarHandler() 返回long型 (常用)
    public static long selectCount(String sql, QueryRunner queryRunner) throws SQLException {
        long count = (Long) queryRunner.query(sql,new ScalarHandler(),new Object[]{});
        // System.out.println(count);
        return count;
    }

    // BeanListHandler 封装javabean对象到list中 (常用)
    private static void selectStudents(String sql, QueryRunner queryRunner) throws SQLException {
        List<Student> students = (List<Student>) queryRunner.query(sql,new BeanListHandler(Student.class),new Object[]{});
        for (Student student:students){
            System.out.println(student);
        }
    }

    // BeanHandler 封装单个javabean对象到Student中
    private static void selectStudentByID(String sql, QueryRunner queryRunner) throws SQLException {
        Student student = (Student) queryRunner.query(sql,new BeanHandler(Student.class),new Object[]{1});
        System.out.println(student);
    }

    // ArrayListHandler 封装到List集合对象
    private static void queryStudents(String sql, QueryRunner queryRunner) throws SQLException {
        List<Object[]> values = null;
        values =  queryRunner.query(sql,new ArrayListHandler(),new Object[]{});
        // 遍历list
        for(Object[] objects : values){
            for(Object object:objects){
                System.out.print(object+"\t");
            }
            System.out.println();
        }
    }

    private static void updateStudent(QueryRunner queryRunner,String sql) throws SQLException {
        queryRunner.update(sql,new Object[]{6,"aqie",1});
    }
}
