package ReflectionOfGeneric;

import base.entity.Student;

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
