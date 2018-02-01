package myAOP;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 重复代码
@Component("comment")
@Aspect             // 指定一个类为切面类
public class AnnotationAop {
    // 执行业务代码 之前执行
    public void just(){
        System.out.println("just");
    }

    // 执行业务代码 之后执行
    public void doit(){
        System.out.println("do it!");
    }
}
