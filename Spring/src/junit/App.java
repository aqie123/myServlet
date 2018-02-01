package junit;

import base.action.AnimalAction;
import base.action.UserAction;
import base.entity.Animal;
import base.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml",App.class);
    private ApplicationContext ac2 = new ClassPathXmlApplicationContext("bean2.xml",App.class);

    public static void main(String[] args) {
        // test();
        App app = new App();
        // app.test2();
        // app.test3();
        // app.test4();
        // app.test5();
        // app.test6();
        app.test7();
    }

    // 自动装配
    private void test7(){
        Animal animal = (Animal)ac2.getBean("animal");
        System.out.println(animal);
        AnimalAction action = (AnimalAction)ac2.getBean("animalAction");
        action.execute();
    }

    // p 名称空间给属性注入
    private void test6(){
        User user = (User)applicationContext.getBean("user6");
        System.out.println(user);
    }

    // 依赖注入应用
    private void test5(){
        UserAction action = (UserAction)applicationContext.getBean("base/action");
        action.execute();
    }

    // IOC容器，给对象属性赋值
    private void test4(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",this.getClass());
        User user5 = (User)ac.getBean("user5");
        System.out.println(user5);
    }

    // 通过工厂创建对象
    private void test3(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",this.getClass());
        User user3 = (User)ac.getBean("user3");
        System.out.println(user3);

        User user4 = (User)ac.getBean("user4");
        System.out.println(user4);
    }

    // 有参和无参构造函数构造对象
    private  void test2() {
        // 从当前类所在包下找 bean.xml (测试方便)
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",this.getClass());
        User user = (User)ac.getBean("user");

        // 获取容器中字符串
        String str = (String)ac.getBean("str");
        System.out.println(str);
        // 使用有参构造函数构造对象
        User user2 = (User)ac.getBean("user2");
        System.out.println(user2);
    }

    // 通过src目录下 applicationContext.xml 创建容器对象
    private static void test() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("=======华丽的分隔符=========");
        // 可以使用id
        User user = (User)ac.getBean("userBean");
        // 也可是使用name
        User user2 = (User)ac.getBean("user2");
        // 这是新的对象
        User user6 = (User)ac.getBean("user6");
        // 这是多态
        User user7 = (User)ac.getBean("user6");
        ac.destroy();
    }

}
