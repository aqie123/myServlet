package action;

import service.UserService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// 多例的Action实例,在访问时创建对象
public class UserAction {
    // 创建service
    private UserService userService = new UserService();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute(){
        return "success";
    }

    public static void main(String[] args) {
        ConcurrentMap<String,String> map = new ConcurrentHashMap<>();//初始化为空
        map.put("A", "123");//put值
        String valuex = map.putIfAbsent("xx", "abc");
        System.out.println(valuex);
        System.out.println(map.get("xx"));
        System.out.println(map.get("A"));
        // Q：请问 valuex=？
    }
}
