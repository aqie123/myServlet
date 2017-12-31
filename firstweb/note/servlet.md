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
        1.init(ServletConfig):Servlet生命周期方法,一定会被tomcat调用
        2.inti()提供给开发者方便覆盖，编写初始化逻辑
三：ServletConfig 对象 : servlet 配置对象 ConfigServlet
    1.主要把servlet初始化参数封装到对象中
    2.config.getInitParameter("path")       根据名称获取参数值
    3.config.getInitParameterNames()        获取所有参数值
    4.一个网站可能有多个servlet对象,一个servlet封装
    5.调用init方法前创建。ServletContext对象创建前
四：ServletContext对象 : servlet上下文对象  ContextServlet
    1.整个网站只会创建一个
    2.this.getServletConfig().getServletContext()
    3.启动时创建
    4.作用：
        1.获取web上下文路径 java.lang.String getContextPath()
            就是项目在tomcat服务器运行的路径,不是项目开发路径
            获取文件路径更灵活
        2.获取全局参数 
            java.lang.String getInitParameter
            java.util.Enumeration getInitParameterNames()
        3. 和域对象相关(不同资源之间用来共享数据,保存数据获取数据)
            void setAttribute
            java.lang.Object getAttribute
            void removeAttribute
        4.请求转发
            RequestDispatcher getRequestDispatcher
        5.读取web项目资源文件
            java.lang.String getRealPath(java.lang.String path)
            获取资源文件的真实路径
            java.io.InputStream getResourceAsStream(java.lang.String path)
            java.net.URL getResource(java.lang.String path)
    5.配置在web.xml 在servlet外面
        1.tomcat会把web.xml(包括全局参数)封装到ServletContext对象中
        2.该网站下任何servlet均可通过ServletContext获取到全局变量
        3.servlet间共享数据
            1. response.sendRedirect("/servlet2?name=aqie")
            2.
五：ServletRequest ServletResponse 对象
六：域对象
    1.servletContext 就是第一个域对象
    2.HttpServletRequest
    3.HttpSession
七：
    请求转发：
        1.地址栏不变
        2.转发只能转发当前项目资源
        3.浏览器只发出一次请求，能使用请求作用域对象来共享数据
        4.
    重定向
        1.可跳转其他项目资源
        2.浏览器发出两次请求，不能使用请求作用域对象来共享数据
八：路径
    1. 服务器 / 代表当前项目的跟目标
    2. 浏览器 / 代表当前站点的根目录