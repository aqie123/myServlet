package myAOP;

import org.aspectj.weaver.ast.Or;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private  ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",getClass());
    private  ApplicationContext ac2 = new ClassPathXmlApplicationContext("bean2.xml",getClass());
    public static void main(String[] args) {
        App app = new App();
        // app.test();
        // app.test2();
        // app.test3();
        app.test4();
    }
    private void test4(){
        // cglib代理 不实现接口
        OrderDao orderDao = (OrderDao) ac2.getBean("orderDao");
        orderDao.save();
    }
    // 注解方式(实现AOP编程)  AnnotationAop.java
    private void test3(){
        Dao adminDao = (Dao) ac2.getBean("adminDao");
        adminDao.save();
        System.out.println(adminDao.getClass());
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
