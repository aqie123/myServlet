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
    1.Class 类：代表类
    2.Constructor 类：代表类
    3.Method 类 ：普通方法
    4.Field 类 ： 类的属性
四：泛型
五：反射泛型(新)
六：注解
七：反射注解
八：类加载器
九：断言
    1. intellij 开启断言 ： 
        RUN -> Edit Configurations -> Configuration -> 
        VM options : 输入-ea，点击确定。
    2.