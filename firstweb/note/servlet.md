一：Servlet
    1.概念
        1.servlet 普通类 extends HttpServlet
        2.实现 servlet接口 才是servlet类
        3.servlet程序交给tomcat程序运行
    2. servlet执行过程
        1. 截取url，得到需要访问的资源名称 hello
        2.web.xml中匹配url-pattern
        3.使用当前servlet-name,匹配servlet中是否有相同名称
        4.取出servlet-class内容
        5.通过反射得到对象
    3. servlet 映射路径 (先找动态网页,再找静态网页)
        1.url-pattern 精确匹配 模糊匹配
        2.模糊匹配
            /*      匹配任意路径
            /aqie/* 
            *.action 任意路径+后缀
            *.html
        3.精确匹配优先度最高,后缀结尾优先度最低
        4,缺省路径 <url-pattern>/</url-pattern>
            被DefaultServlet匹配,
            用处：专门处理所有网站中的静态网页
    4. servlet生命周期  LifeServlet
        1.构造方法  ：Servlet 单例的
        2.init(ServletConfig)方法 ：只调用一次用于初始化
        3.service(request,response)方法 : 逻辑代码被调用
        4.destory()方法
    5. 服务器如何调用四个方法
        1.创建HelloServlet对象,
            Class clazz = Class.forName("HelloServlet");
        2.通过class对象调用构造方法
           Object obj =  clazz.newInstance(); 调用无参构造方法
        3.通过反射调用init方法
            得到init方法对象
            Method m = clazz.getDeclaredMethod("init"); // 对象
            调用方法
            m.invoke(obj,config);
        4.通过反射得到service方法
            得到service方法对象
            Method m = clazz.getDeclaredMethod("service",HttpServletRequest.class,HttpServletResponse.class);
            调用方法
            m.invoke(obj,request,response);
        5.通过反射得到destroy方法
            得到destory方法对象
            Method m = clazz.getDeclareMethod("destroy");
            m.invoke(obj,null);
二：servlet线程并发 ThreadServlet
    1.单实例多线程
        a.给使用到共享数据的代码块添加同步锁
        (注意同步锁是多线程唯一的)
        b.尽量不要使用成员变量,或者静态成员
        c.必须使用成员变量,要给使用了成员变量的代码块加锁
            代码块范围尽量小，有可能影响程序并发
    2.servlet自动加载机制
        1.默认servlet对象是在第一次访问时候创建
        2.servlet构造方法或者init执行较多逻辑，用户体验不好
        3.让servlet在服务启动时自动加载
        4.<load-on-startup>1</load-on-startup>数字越小越先创建
        5.GenericServlet 通用的不基于任何协议的Servlet实现
        6.HttpServlet 基于Http协议
    3.Servlet的init方法
        1.init(ServletConfig)
        2.inti()
三：servlet config 对象
四：servlet context对象