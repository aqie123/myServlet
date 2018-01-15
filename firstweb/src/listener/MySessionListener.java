package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

public class MySessionListener implements HttpSessionListener ,HttpSessionAttributeListener{
    /**
     * 用于存储当前网站的访客数量
     * 每次创建一个session对象 就代表一个在线访问人数
     * 用户访问的session被销毁代表用户离线
     */
    private int count;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("一个session对象被创建");
        /**
         * 避免多个用户同时访问 线程并发
         */
        synchronized (httpSessionEvent){
            count++;
            // count 通过context域对象共享到jsp页面
            // 通过session对象获取ServletContext对象
            ServletContext context = httpSessionEvent.getSession().getServletContext();
            context.setAttribute("count",count);
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("一个session对象被销毁");
        synchronized (httpSessionEvent) {
            ServletContext context = httpSessionEvent.getSession().getServletContext();
            count--;
            context.setAttribute("count", count);
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        Object value = httpSessionBindingEvent.getValue();
        System.out.println("Session属性被创建 ："+name+": "+value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        System.out.println("Session属性被删除 ："+name);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        HttpSession session = httpSessionBindingEvent.getSession();
        Object value = session.getAttribute(name);
        System.out.println("Session属性被修改 ："+name+": "+value);
    }
}
