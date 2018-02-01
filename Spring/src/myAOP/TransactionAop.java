package myAOP;

import org.springframework.stereotype.Component;

@Component("aop")
public class TransactionAop {
    public void beginTransaction(){
        System.out.println("开启事务");
    }

    public void commit(){
        System.out.println("提交事务");
    }
}
