package Annotation;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射注解
 */
public class CustomAnnotation {
    @Test
    @Note(note="test")
    @Author(name="aqie",modifyTime = "2018-1-25 14:01:00",notes = {"1","this is note"},value={"ss","aa"})
    public void test() throws NoSuchMethodException {
        Class c;
        Method m = null;
        Field f;
        Constructor con;
        /*c.getAnnotation(null);  // 获取类上面注解
        m.getAnnotation(null);  // 获取方法上注解
        f.getAnnotation();  // 获取属性上注解
        con.getAnnotation(null);    // 获取构造函数上面注解
        */

        // 1.得到save方法对象
        m = this.getClass().getMethod("test",null);

        // 2.得到方法上面注解
        Author author = m.getAnnotation(Author.class);
        System.out.println(author);

        // 3.获取注解里面属性
        String name = author.name();
        String time = author.modifyTime();
        System.out.println(name);
        System.out.println(time);

    }

    @Note(note="name")
    public String name;
}
