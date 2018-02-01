package base.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import base.service.UserService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// 多例的Action实例,在访问时创建对象
public class UserAction {
    // 创建service
    private UserService userService = new UserService();

    // 接收IOC容器注入值
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void execute(){
        userService.save();
        System.out.println("success");
    }

    public static void main(String[] args) {
        // test();
        // test1();
        test2();
    }

    // 从IOC容器读取对象 applicationContext.xml 配置文件
    private static void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        UserAction userAction = (UserAction)ac.getBean("base/action");
        userAction.execute();
    }

    // 直接调用
    private static void test1() {
        UserAction action  = new UserAction();
        action.execute();
    }

    private static void test() {
        ConcurrentMap<String,String> map = new ConcurrentHashMap<>();//初始化为空
        map.put("A", "123");//put值
        String valuex = map.putIfAbsent("xx", "abc");
        System.out.println(valuex);
        System.out.println(map.get("xx"));
        System.out.println(map.get("A"));
        // Q：请问 valuex=？
    }
}
