一：监听器 Listener  在web.xml 注册监听器
    1.GUI的事件编程三要素
        1.事件源 Frame/JFrame Button/JButton
        2.事件：MouseEvent WindowEvent KeyEvent
        3.事件监听器：MouseListener WindowListener KeyListener
    2.
        1.SWING:轻量级GUI组件,不依赖操作系统 java.swing.*
        2.(AWT 重量级的GUI组件)依赖操作系统,java.awt.*
    3.需求：
        1. 点击窗体关闭,窗体关闭,且程序关闭
    4.Web 的事件编程
        1.事件源：ServletContext对象 ServletRequest 对象 HttpSession对象  
            (都是域对象)
        2.事件及触发：
            创建销毁对象:ServletContextEvent, 
                    ServletRequestEvent, HttpSessionEvent
            (修改,增加,删除)对象：ServletContextAttributeEvent
                                  ServletRequestAttributeEvent
                                  HttpSessionAttributeEvent
        3.事件监听器(接口)：ServletContextListener, 
            ServletRequestListener, HttpSessionListener
            ServletContextAttributeListener, 
            ServletRequestAttributeListener, 
            HttpSessionAttributeListener
    5.web监听器：实现(特定接口)的java程序,用于监听web开发中
        常用对象(ServletContext,ServletRequest，HttpSession)的创建和销毁行为.
        以及这些对象的属性修改行为(setAttribute,removeAttribute)
二：Context 监听器初始化和清理工作 MyContextListener.java
    1.ServletContext 对象
        创建：加载当前web项目时
        销毁：关闭服务器或重新部署web项目
    2.需求：在项目启动时，初始化表 (ServletContextListener)
            项目结束，删除表
    3. (ServletContextListener) : 
        对象创建,销毁     
    4.ServletContextAttributeListener : 对象属性的增加,修改,删除行为  
        http://localhost:8080/listener/context.jsp
        增加：setAttribute("name",Object);
        修改：setAttribute("name",Object);  // 同名属性修改
        删除：removeAttribute("name");
三.ServletRequestListener   MyRequestListener.java
   1.ServletRequest对象(request请求对象)的创建和销毁行为
        创建：用户每次发送请求时都会创建一个请求对象
        销毁：完成整个请求之后对象销毁
   2.ServletRequestListener ：请求对象创建
        http://localhost:8080/listener/request.jsp  
   3.ServletRequestAttributeListener： request.setAttribute("name","啊切");
三：Session 监听器统计在线访客人数  MySessionListener.java  listener/session.jsp
    1.HttpSession
        创建：request.setSession(true);
        销毁：1.默认情况30分钟,系统自动回收session对象
              2.session.setMaxInactiveInterval(秒数); 
                全局设置session回收时间
                <session-config>
                    <session-timeout>分钟数</session-timeout>
                </session-config>                  
              3.session.invalidate(); 手动销毁session对象
    2.http://192.168.0.135:8080/listener/session.jsp
    3.统计当前网站访客数量
    4.HttpSessionAttributeListener : session属性修改监听
四：在线登录用户
    1. 需求：用户可登录退出网站
             用户登录后,查询当前网站在线的登录用户信息
             管理员可以踢出某个登录的用户
    2. 文件
        1.http://192.168.0.135:8080/sessionLogin/login.jsp   sessionLogin/userInfo.jsp
        2./session/logout 退出  /session/login 登录
        3.OnLineBean.java  封装登陆用户所有信息
        4.GetOnlineServlet
    3. 步骤 注册OnlineListener
        1.一个登录用户登录信息使用一个session对象保存
        2. 登录名 ：session.setAttribute("name",name);
        3. 登录时间：session.getCreationTime();
        4. 上次登陆时间：session.getLastAccessedTime();
        5. 登录ip：session.getAttribute("ip");
        6. 登陆成功后,封装session对象到map集合中,map集合放入context域中
        7. 查看用户登录信息通过 GetOnlineServlet转发
        8. session属性监听器负责 context域中对象信息添加删除
        9. 退出 SessionLogoutServlet  OnLineListener
        10. 踢出
        11. GetOnlineServlet 加锁
        12.权限 PermissionFilter
五：文本和日期国际化  MultiLanguage/MyResourceBundle
     a.  文字国际化
        1. 中国：年月日时分秒
           美国：月日年时分秒
           英国：日月年时分秒
        2.文字国际化 getBundle : http://192.168.0.135:8080/multiLanguage/multiLanguage.jsp
        3.ResourceBundle:用于根据不同国家语言加载不同资源包
        4. note: ÓÃ»§Ãû  fmt:message中文乱码
    b.日期国际化
        1. http://192.168.0.135:8080/multiLanguage/multiDate.jsp
    c.总结
        1.文本：ResourceBundle
        2.日期：DateFormat