package Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    // 声明属性
    String name() default "啊切";
    String modifyTime();
    String[] notes();   // 带有数组类型的属性
    String[] value();   // 如果只有一个，并且注解属性名为value,则使用时可以不写
}
