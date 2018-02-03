package xmlAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private  ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",getClass());
    public static void main(String[] args) {
        App app = new App();
        app.test();
    }
    private void test(){
        Dao userDao = (Dao)ac.getBean("userDao");
        userDao.save();
        userDao.get();
    }
}
