package ptm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",getClass());
    ApplicationContext ac2 = new ClassPathXmlApplicationContext("bean2.xml",getClass());
    public static void main(String[] args) {
        App app = new App();
        // app.test();
        app.test2();
    }
    void test(){
        Service deptService = (Service)ac.getBean("deptService");
        deptService.save();
    }
    // 注解方式实现
    void test2(){
        Service deptService = (Service)ac2.getBean("deptService");
        deptService.save();
    }
}
