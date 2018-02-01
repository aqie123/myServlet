package myAOP;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 面向过程分离
 * 对象分离化
 */
@Repository         // 对象放入ioc容器
public class UserDao {
    @Resource
    private TransactionAop aop;
    public void save(){
        aop.beginTransaction();
        System.out.println("save");
        aop.commit();
    }
}
