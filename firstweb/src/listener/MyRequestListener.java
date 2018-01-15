package listener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  ServerRequest的监听器
 */
public class MyRequestListener implements ServletRequestListener,ServletRequestAttributeListener{
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("一个请求对象被创建");
        // 得到请求对象相关信息
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        // 得到客户IP地址
        String ip = request.getRemoteHost();
        // 共享数据到页面
        HttpSession session = request.getSession(true);
        session.setAttribute("myip",ip);
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("一个请求对象被销毁");
    }
    /** ****************************** 属性相关 ******************************** **/
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();
        System.out.println("request监听器：属性添加 "+name+" : "+value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        System.out.println("request监听器：属性删除 "+name);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        ServletRequest request = servletRequestAttributeEvent.getServletRequest();
        Object value = request.getAttribute("name");            // 修改后属性
        System.out.println("request监听器：属性修改 "+name+" : "+value);
    }
}
