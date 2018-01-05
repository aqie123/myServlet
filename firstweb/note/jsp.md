一：jsp
    1.步骤
        a.hello.jsp (翻译)-> hello_jsp.java
        b.hello_jsp.java (编译)-> hello_jsp.class
        c.读取class文件 创建类对象 hello_jsp
        d. 执行 hello_jsp中方法
    2. 第二次访问 直接执行第四步
    3. jsp的源文件就是一个servlet
二：对比
    servlet：
        生命周期
            1.构造方法
            2.init方法
            3.service方法
            4.destory 方法
    jsp：
        生命周期
            1.翻译(java文件)
            2.编译(class文件)
            3.构造方法：
                _jspInit
                _jspService
                _jspDestory
三：jsp语法
    1.jsp模板：html代码就是模块
    2.jsp表达式：<%= 变量或表达式 %>
        作用：向浏览器输出变量值或表达式
        原理：out.print() 向浏览器输出内容
    3.jsp脚本    <%java语句%>
        作用：执行java语句
        原理：脚本翻译到java文件的 _jspService方法执行
        注意：脚本不能声明方法
    4.jsp声明     <%! 变量或方法%>
        作用：声明变量或方法
        原理：声明变量为成员变量,声明方法是成员方法
    5.jsp注释
        1. <%--jsp注释--%>
            html注释会被翻译执行,jsp注释不会被执行
四：jsp三大指令 <%@ 指令 %>
    1.taglib
    2.include:用于包含其他页面
        原理：直接把包含和被包含内容合并在一起,
        然后翻译成一个java源文件(源码包含或静态包含)
    3.page：告诉浏览器如何翻译jsp文件  a.jsp
        1.pageEncoding 使用什么编码翻译jsp
        2.contentType  服务器发送给浏览器数据类型
            和内容编码格式
        3.errorPage 指定jsp错误处理页面
        4.isErrorPage:指定当前页面是错误处理页面,并可使用
            内置对象exception查看错误信息
        5.buffer jsp页面缓存区大小
        6.isELIgnored 是否忽略EL表达式
        7.
五：
    1.配置全局错误处理页面 web.xml
六：jsp最佳实践，怎么用
    1.servlet ： java开发动态网页,编写java 输出HTML代码
    2.jsp:编写java 输出HTML代码
    3. 分工：
        1.servlet  :    编写java代码
        2.jsp      ：   输出HTML代码
    4.项目涉及功能：
        1.接收参数信息 (servlet)
        2.执行业务逻辑CURD (servlet)
        3.返回结果，输出结果(jsp)
        4.跳转页面 (servlet)
    5. 应用 servlet 传递数据，jsp展示
        1.ListUserServlet  
七：九大jsp内置对象(request,response,session,servletcontext)
        对象名     类型
    1.request   HttpServletRequest      请求对象
    2.response  HttpServletResponse     响应对象
    3.config    ServletConfig           配置对象
    4.application ServletContext        servlet上下文对象
    5.session    HttpSession            会话对象
    6.exception  Throwable              异常信息对象
    7.this       Object                 jsp文件翻译后java类
    8.out       JspWriter(相当于带缓存的 PrintWriter)   输出对象 response.getWriter()  PrintWriter()
        1.缓存满了  2.jsp页面执行完毕 3.缓存关闭 4.手动刷新缓存
    9.pageContext PageContext           jsp的上下文对象
        1.作用：通过pageContext对象获取其他8个内置对象
        2.场景：使用自定义标签
        3.
八：四个域对象 (request,session,application,page)   
     1. request 域： HttpServletRequest
        application 域：ServletContext
        session 域：HttpSession
        page 域：PageContext
     2.域对象方法
        setAttribute()
        getAttribute()
        removeAttribute()
     3.域的作用范围
        从小到大
        page 域：在同一个jsp页面数据有效
        request域：在同一个请求数据有效
        session域：在同一个会话中数据有效
        application域:在同一个网站数据有效
     4.自动搜索四个域数据
        pageContext.findAttribute("name");