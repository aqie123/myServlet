package xmlAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

// 切面类
// @Component("aop")
public class TransactionAop {
    public void beginTransaction(){
        System.out.println("开启事务");
    }

    public void commit(){
        System.out.println("提交事务");
    }
    public void afterReturning(){
        System.out.println("[返回后通知]");
    }

    public void afterThrowing(){
        System.out.println("[异常通知]");
    }

    public void around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("[环绕前：]");
        pjp.proceed();    			   // 执行目标方法
        System.out.println("[环绕后：]");
    }
}
