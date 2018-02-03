package xmlAop;

import org.springframework.stereotype.Repository;


/**
 * xml 配置 实现AOP编程
 */
// @Repository         // 对象放入ioc容器
public class UserDao implements Dao{
    public void save(){
        System.out.println("save");
    }

    @Override
    public void get() {
        System.out.println("get!");
    }
}
