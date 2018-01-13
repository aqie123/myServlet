一：过滤器 MyFilter/FirstFilter.java
    1.场景：servlet中获取用户参数:request.getParameter("参数名")
         遇到参数内容中文乱码
         post 提交：request.setCharacterEncoding("utf-8");
         get 提交：手动解码 name = new String(name.getBytes("iso-8859-1"),"utf-8");
         通过过滤器把重复操作写进过滤器
        场景2：登录页面->输入用户名密码->后台检查->登录成功->(数据放在session域中)
            判断用户登录权限
    2. 作用
        1.过滤器就是一个实现Filter接口 javax.servlet.Filter 的对象
        2.对象在请求资源(动静态网页),(请求和响应资源时),执行过滤任务
    3.过滤器生命周期
        1. 构造方法：创建过滤器对象时调用,加载当前项目时加载过滤器,只调用一次,单实例多线程
        2. init方法：创建完过滤器对象后只调用一次
        3. doFilter: 过滤任务方法
        4. destory ：销毁
    4.配置
        1.在web.xml配置
        2.精确过滤：/target
        3.模糊过滤：/* , /target/*, *.后缀名, *.do
    5.FilterConfig 对象
    6.FilterChain 过滤器链对象 ： 一个资源被多个过滤器过滤,形成过滤器链
        

二：note
    1.Servlet有三大组件：
        Filter:
        Servlet:用于开发动态网页
        Listener
    2.sp有九大内置对象：application、session、request、response、out、page、pagecontent、config、exception
    3.javaEE三大组件技术：Servlet，JSP，EJB
三：servlet
    1.特点：
        1.组件配置到web.xml
        2.组件交给tomcat运行
四：装饰者模式
    1. 编写一个BufferedReader装饰类,继承被装饰类
    2. 装饰类中继承一个成员变量,接收被装饰者类的对象
    3. 在装饰者类的构造方法中,传入被装饰者类,使用上面成员变量,接收被装饰类
    4. 在装饰类中重写被装饰类中方法
五：参数编码过滤器解决参数中文乱码 gibberish
    1. GetParamServlet.java(/gibberish/login)  http://localhost:8080/login.html  
    2. EncodingFilter
    3. HttpServletRequestWrapper(被装饰者) -> HttpServletRequest(接口)
        自定义类 装饰者(MyHttpRequest)
六：压缩网页内容 : gzip压缩技术  compression
    1. ContentServlet
    2.压缩前内容(writer(byte[]))->GZIPOutputStream(ByteArrayOutputStream)
        ->ByteArrayOutputStream(缓存容器)->byte[] toByteArray()->压缩后内容
    3. 实现gzip压缩过滤器 (GzipFilter)
        1.ContentServlet
        2.GzipFilter
    4. response.getWriter(PrintWriter对象) 不带有缓存对象->浏览器
        缓存容器(Writer对象) : 用于存储网页内容 ->从缓存容器Writer对象中获取网页内容
        ->gzip压缩—>发送压缩后内容到浏览器
        核心：改造HttpServletResponse对象的getWriter()方法,该方法返回一个带
                缓存功能的PrintWriter对象
七：用户权限过滤器  (过滤器验证的是 servlet 路径)
    1.登录步骤 login.jsp->login.servlet->index.jsp
    2. login.html login.LoginServlet
    3. SecurityFilter.java  modify.jsp
