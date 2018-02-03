package myAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 重复代码
@Component("comment")
@Aspect             // 指定一个类为切面类
public class AnnotationAop {
    // 定义切入点表达式变量
    @Pointcut("execution(* myAOP.*.*(..))")
    // @Pointcut("execution(* myAOP.AdminDao.*(..))")   // 针对AdminDao
    public void pointcut_(){}

    // 【前置通知】执行业务代码 之前执行
    @Before("pointcut_()")
    public void just(){
        System.out.println("前置通知 开启事务");
    }

    // 【后置通知】执行业务代码 之后执行
    @After("pointcut_()")
    public void doit(){
        System.out.println("后置通知 提交事务");
    }

    // 【返回后通知】   在执行目标方法结束后执行, 出现异常不会执行
    @AfterReturning("pointcut_()")
    public void afterReturning(){
        System.out.println("返回后通知");
    }

    // 【异常通知】   在执行目标方法的时候出现异常执行
    @AfterThrowing("pointcut_()")
    public void afterThrowing(){
        System.out.println("异常通知");
    }

    // 【环绕通知】 会环绕目标方法执行
    @Around("pointcut_()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕前");
        pjp.proceed();              // 执行目标方法
        System.out.println("环绕后");

    }
}
