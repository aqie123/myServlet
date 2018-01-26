package ReflectionOfGeneric;

import entity.Student;
import mysql.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 反射泛型
 */
public class StudentDao extends BaseDao2<Student>{
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        List<Student> list = dao.findAll();
        for (Student student : list){
            System.out.println(student);
        }
        /*Student student = dao.findByID(3);
        System.out.println(student);*/
    }

}
