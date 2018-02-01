package myAOP;

import org.springframework.stereotype.Component;

// 重复代码
@Component("comment")

public class AnnotationAop {
    public void just(){
        System.out.println("do it!");
    }
}
