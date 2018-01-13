一：监听器 Listener
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
二：Context 监听器初始化和清理工作
    1.
三：Session 监听器统计在线访客人数
四：在线登录用户
五：文本和日期国际化