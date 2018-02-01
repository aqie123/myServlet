package myAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private  ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",getClass());
    public static void main(String[] args) {
        App app = new App();
        // app.test();
        app.test2();
    }

    // 面向过程分离
    private void test() {
        UserDao dao = (UserDao) ac.getBean("userDao");
        dao.save();
    }

    // 面向切面编程
    private void test2(){
        AdminDao dao = (AdminDao)ac.getBean("adminDao");
        dao.save();

        // 这里是代理类 (这里要用父类接口接收)
        Dao dao2 = (Dao) ac.getBean("adminDaoProxy");
        dao2.save();
    }
}
