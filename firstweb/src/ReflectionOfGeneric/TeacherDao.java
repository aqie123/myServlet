package ReflectionOfGeneric;

import base.entity.Student;
import mysql.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 反射泛型
 */
public class TeacherDao {
    private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
    public List<Student> findAll(){
        try {
            return (List<Student>)qr.query("select * from student",new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Student findByID(int id){
        try {
            return (Student)qr.query("select * from student where id = ?",new BeanHandler<>(Student.class),new Object[]{id});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
