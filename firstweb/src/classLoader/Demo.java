package classLoader;

import org.junit.Test;

import java.util.Date;

public class Demo {
    @Test
    public void test(){
        /**
         * 1.系统提供三个类加载器
         *      BootStrap 加载器 加载 jdk/jre/lib/rt.jar (开发时用的核心类)
         *      ExtClassLoad 加载器 加载 jdk/jre/lib/ext/*.jar (扩展包)
         *      AppClassLoader 加载器 加载CLASSPATH 中的jar 和class文件
         * 2.三个类加载器是树状结构
         * 3.类加载过程
         */
        // 得到类加载器
       ClassLoader classLoader = Demo.class.getClassLoader();
       while (classLoader != null){
            System.out.println(classLoader.getClass());
            classLoader = classLoader.getParent();
       }
       // System.out.println(classLoader);
       System.out.println(Date.class.getClassLoader());
    }
}
