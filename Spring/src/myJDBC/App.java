package myJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",App.class);
    public static void main(String[] args) throws Exception {
        App app = new App();
        //app.test();
        // app.test2();
        // app.test3();
        // app.test4();
        // app.test5();
        // app.test6();
        // app.test7();
        // app.test8();
        app.test9();
    }
    // 原始jdbc代码
    private void test() throws Exception {
        DeptDao dao = (DeptDao) ac.getBean("deptDao");
        dao.save(new Department());
    }

    // 接收容器注入的DataSource 对象
    private void test2()throws Exception{
        Dept2Dao dao = (Dept2Dao) ac.getBean("dept2Dao");
        dao.save(new Department());
    }

    // 引入JdbcTemplate 对象
    private void test3(){
        Dept3Dao dao = (Dept3Dao) ac.getBean("dept3Dao");
        dao.save(new Department("Marketing Department"));
    }

    // 配置简化JdbcTemplate 对象
    private void test4(){
        Dept3Dao dao = (Dept3Dao) ac.getBean("dept3Dao");
        dao.save2(new Department("Marketing Department2"));
    }

    private Dao dept4Dao = (Dao)ac.getBean("dept4Dao");
    private Department dept = (Department) ac.getBean("department");
    // 保存
    private void test5(){
        dept.setName("Marketing Department4");
        dept4Dao.save(dept);
    }
    // 删除
    private void test6(){
        dept4Dao.delete(12);
    }
    // 更新
    private void test7(){
        dept.setName("Marketing Department4");
        dept.setId(11);
        dept4Dao.update(dept);
    }
    // 查询单条数据
    private void test8(){
        Department department = dept4Dao.findById(3);
        System.out.println(department);
    }

    // 查询多条数据
    private void test9(){
        List<Department> list = dept4Dao.getAll();
        for(Department department : list){
            System.out.println(department);
        }
    }
}
