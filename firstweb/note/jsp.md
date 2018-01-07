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
        pageContext.findAttribute("name")
 九：EL表达式(代替jsp表达式,jsp页面尽量少些或者不写java代码) EL
    1.作用：
        浏览器输出变量或表达式技术的结果
    2.EL表达式： 
        a.EL从四个域中自动搜索
            ${name} 等价于 <%=pageContext.findAttribute("name")%>
        b.EL从指定域中获取            
    3.EL获取不同类型数据
        1.普通字符串
        2.普通的对象
            EL表达式对象属性 调用对象的getName方法
        3.数组或List集合
        4.Map集合
    4.执行表达式
        1.算数表达式 +-*/
        2.比较表达式 > < == 
        3.逻辑表达式 && || !
        4.三目表达式
        5.判空表达式 null
            empty(null '')
 十：EL  11个内置对象
    1.pageContext
    2.pageScope
    3.requestScope
    4.sessionScope
    5.applicationScope
    6.param
    7.paramValues
    8.header
    9.headerValues
    10.cookie
    11.initParam
十一：内置对象作用
    1.获取上下文路径
    2.获取参数
    3.获取请求头 header
十二：jsp标签  tags
    1.EL表达式可以替换jsp表达式，但是不能条件判断,不能赋值,不能迭代
    2.分类
        1.jsp内置标签(动作标签) 不需要导入标签库
            <jsp:forward/> 转发标签
            <%request.getRequestDispatcher("/mytags/action.html").forward(request,response);%>
            <jsp:param/>   参数标签
            <jsp:include/>  包含标签  (动态包含)
            原理：包含与被包含页面单独翻译成不同java页面,运行时合并在一起
            区别：静态包含不能携带参数,动态包含可以
        2.jstl标签(java standard tag library 标准标签) 导入标签库  
            1.分类(http://tomcat.apache.org/taglibs/standard/)
                1.核心标签库(重要core)
                2.国际化标签库(fmt)
                3.EL函数库(fn)
                4.SQL标签库(sql)
                5.XML标签库(x)
            2.导入
                1.使用jsp页面,在jsp顶部用taglib指令导入需要标签库
                2.uri:需要导入标签库的uri名称,每个标签库都会有个tdl后缀名的标签声明文件,
                      tld文件中有唯一的uri名称,uri名称就是当前标签库名称
                  prefix:使用标签库的前缀,通用和tld文件的short-name名称相同
                3.D:\coreJava\myServlet\firstweb\web\WEB-INF\lib 导入标准标签库
        3.自定义标签 导入标签库
    3.核心标签库 （jstl/core/index.jsp）
        1.
        保存数据：var 数据名称   value:保存的值 
                scope保存到哪个域
                page:page域
                request:request域
                session：session域
                application:application域              
        <c:set></c:set>
        2.
        获取数据:获取域中值，如果数据在域中，必须使用EL语法去
        default:当前需要获取内容为null,使用
        escapeXml 默认情况为true,out标签会把输入的内容转义
        <c:out value=""></c:out>
        3.
        单条件判断: test返回true就会执行标签体内容       
        <c:if test=""></c:if>
        4.
        多条件判断:
        <c:choose></c:choose>
        <c:when test=""></c:when>
        <c:otherwise></c:otherwise>
        5.
        用于迭代(循环):
        begin:从哪个元素开始遍历，0开始
        end:从哪个元素截止 
        step:增加的步长
        Items:默认遍历数据(数组|List集合|Map集合)获取域数据,使用EL表达式
        var:每个元素名称
        varStatus:当前状态对象,该对象封装当前元素状态信息,例如count属性,当前遍历是哪个元素
        遍历map对象时,每个Map对象使用Entry封装,
        getKey获取键对象, getValue获取到值对象
        <c:forEach></c:forEach>   
        6. 遍历特殊字符串    
        items:需要遍历的字符串
        delims:指定的分隔符号
        var:每个内容名称
        <c:forTokens items="" delims=""></c:forTokens>
        7.
        重定向
        <c:redirect url=""></c:redirect>
十三：自定义标签 customTag
    1.导入自定义标签 a_tag.ShowIpTag
        WEB-INF下新建ip.tld
    2.应用：获取客户端IP地址
    3.流程：
        1. ShowIpTag extends SimpleTagSupport，覆盖doTag方法
        2. 通过PageContext获取到其他八个内置对象
        3. 将ip输入给浏览器
        4. 在WEB-INF目录下建立一个tld文件 ip.tld
            配置标签前缀 和 标签库唯一名称
            定义标签名称和ShowIpTag 类名
        5.jsp顶部导入自定义标签库
            <%@taglib prefix="aqie" uri="http://www.aqie.com" %>
        6.使用标签
            <aqie:showIp></aqie:showIp>
    4.自定义标签执行过程
        1.http://192.168.0.135:8080/customTag/ip.jsp
        2.读取项目下的WEB-INF文件,包括web.xml和tld文件
        3.翻译java文件->class文件->构造方法->调用_jspService方法
        4.在内存tld文件中查找是否存在uri名为http://www.aqie.com 的tld文件
        5.得到对应tld文件
        6.读取<aqie:showIp>内容,截取showIp名称(标签)，到tld文件查找是否存在
            name为showIp的tag标签
        7.取出tag标签内容 <tag-class>a_tag.ShowIpTag</tag-class>
    5.自定义标签的生命周期
        1. 构造方法：构造标签对象
        2. setJspContext(JspContext pc)
        3. void setParent(jspTag parent) 传入父标签,如果
            没有父标签，则不调用此方法
        4. void setJspBody(JspFragment jspBody)
            传入标签体内容,没有则不调用此方法
        5. void doTag()  调用标签执行方法,业务逻辑
            getJspContext() getParent() getJspBody()
        6.
        
