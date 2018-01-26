一：单元测试 MyJUnit
    1.添加包 org.junit.Test;
    2.注意事项 
        a.给方法添加 @Test 注解,该方法就是一个测试方法,
        b.类似main方法
        c.必须public修饰
        d.不能有返回值
        e.不能有参数
        f.可以抛出异常
    3.如何运行
        1. 直接运行类
        2. 运行单个函数
    4. 测试
        1.TestMathJUnit 单元测试 + 断言类
        2.AssertFoo     断言 assert关键字
二：枚举 (enum 定义枚举类) MyEnum
    1.MyEnum/EvaluatePerformance.java
三：反射 MyReflection
    1.Class 类：代表类,
        得到类名称,实现接口,继承的类
    2.Constructor 类：代表类的构造方法
        构造对象
    3.Method 类 ：普通方法
        调用方法
    4.Field 类 ： 类的属性
        得到属性值,设置属性值
       
四：泛型 Generics
    1.泛型作用
        1.减少手动类型转换
        2.将程序运行时错误提前到编译时报错
    2.泛型语法(泛型方法，泛型类，泛型接口)
        1.泛型类如果定义了泛型,方法上使用同一个类型,则不需要定义泛型
        2. 泛型方法类型在调用方法时确定类型
        3. 泛型类的类型确定 : 在实例化类时确定
        4. 泛型接口类型确定
            1.直接实现泛型接口时确定
            2.继承泛型接口的实现类时确定
    3.泛型关键字 extends/super   ReflectionOfGeneric.Demo
        1. ? 让某个类保持泛型; 如果一个泛型类加上?泛型,该类不能再进行编译,
            只能用于接收数据
        2. extends : 只能接受传入指定类对象及其子类
        3. super   ：只能接受传入指定类对象及其父类
五：反射泛型(新) ReflectionOfGeneric.Demo2  BaseDao
六：注解
    1,影响编译器运行程序结构
    2,作用：
        1. 在程序(类，方法,属性)携带信息
        2. 注解简化/取代配置文件(xml/properties)
        3. 参数放在(xml/注解中)
    3.常见注解 Annotation
        1.@Override : 告诉编译器强制对方法覆盖
        2.@SuppressWarnings(value = "unchecked") : 告诉编译器压制代码中出现的警告
        3.@Deprecated : 运行时提示方法已过期
    4.自定义注解 Author.java
    5. 注解的细节
        1.属性类型可以是基本类型,也可以是数组类型
        2. default添加默认值
        3. 使用value名称属性,则可以省略
    6.元注解
        1. @Target(ElementType.METHOD) : 声明注解的使用范围
            TYPE:     注解可以用在类上
            FIELD:    注解可以用在属性上
            METHOD:   注解可以用在方法上
            PARAMETER:注解可以用在参数上
            CONSTRUCTOR:构造方法
            LOCAL_VARIABLE:用在本地变量上
        2.@Retention(RetentionPolicy.CLASS):声明注解的有效范围
            1.CLASS  : 该注解在源码和字节码有效
            2.SOURCE : 该注解只在源码上有效
            3.RUNTIME: 该注解在源码和字节码有效,运行字节码有效
七：反射注解 ： 通过反射获取注解上面的数据
    1.Annotation.CustomAnnotation
    2.应用 ReflectionOfGeneric.TeacherDao 
        1. 新建表的注解(ReflectionOfGeneric.Table)，
           字段注解(ReflectionOfGeneric.Column)
        2.
    3. BaseDao2 类型转换  Long->Integer  String->Long
八：类加载器 classLoader 
    (http://blog.csdn.net/zhoudaxia/article/details/35824249)
    1.过程
        1.类A由类加载器加载,类A中使用类B,类B也是由类A的类加载器加载
    1.1 三个类加载器
        1.BootStrap 加载器
        2.ExtClassLoad 加载器 
        3.AppClassLoader 加载器
    2.委托机制
        1.发起者类加载器加载类,先委托其父类加载,如果还有父加载器,则继续委托
        2.最顶层类加载器真正加载指定类,如果在其类目录找不到,则继续向下找
        3.找到发起者类加载器为止
    3. 委托机制好处：
        1.类加载更安全高效
        2.保证核心类字节码只有一份在内存中
    4. web: http://192.168.0.135:8080/classLoader
        1.webServlet加载顺序
            1.org.apache.catalina.loader.ParallelWebappClassLoader  (自定义类加载器)
                WEB-INF/class
                WEB-INF/lib   
                作用：
                    1.分离服务器中每个web应用,让每个web应用互不干扰
                    2.打破了委托机制,保持优先加载当前web应用所有资源
            2.java.net.URLClassLoader       (自定义类加载器)
            3.sun.misc.Launcher$AppClassLoader  CLASSPATH
            4.sun.misc.Launcher$ExtClassLoader  (jdk/jre/lib/ext/*.jar (扩展包))
            5.BootStrap (jdk/jre/lib/rt.jar )
        2.
        3.
九：断言
    1. intellij 开启断言 ： 
        RUN -> Edit Configurations -> Configuration -> 
        VM options : 输入-ea，点击确定。
    2.   
十：python
    1.运维 ，大数据 ，爬虫,自动化测试
    2.6210810160000710310