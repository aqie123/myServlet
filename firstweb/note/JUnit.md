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
    3.泛型关键字 extends/super
        1. ? 让某个类保持泛型
        2.
五：反射泛型(新)
六：注解
七：反射注解
八：类加载器
九：断言
    1. intellij 开启断言 ： 
        RUN -> Edit Configurations -> Configuration -> 
        VM options : 输入-ea，点击确定。
    2.
    
十：python
    1.运维 ，大数据 ，爬虫,自动化测试