package sessionLogin;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashMap;
import java.util.Map;

public class OnLineListener implements HttpSessionAttributeListener {
    /**
     *  用户登陆后,执行 session.setAttribute("name",name);
     *  用于监听用户人数增加
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        // 得到属性名
        String name = httpSessionBindingEvent.getName();
        ServletContext context = httpSessionBindingEvent.getSession().getServletContext();
        if("name".equals(name)){
            // 同步代码块,避免多个登录用户操作onLine数据引发并发问题
            synchronized (OnLineListener.class){
                // 1.把当前登录的session对象封装到map集合
                // 1.1 context域中获取session信息
                Map<String,HttpSession> onLine = (Map<String,HttpSession>)context.getAttribute("onLine");
                // 1.2 如果是第一个登录用户,onLine 是null
                if(onLine == null){
                    onLine = new HashMap<>();
                }
                // 1.3 得到当前登录的session对象
                HttpSession session = httpSessionBindingEvent.getSession();
                // 1.4封装,当前用户session存入map集合
                onLine.put(session.getId(),session);
                // 2.封装好的map保存到context域
                context.setAttribute("onLine",onLine);
            }
        }
    }

    /**
     * SessionLogout 在删除session  name和ip时调用
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

        String name = httpSessionBindingEvent.getName();
        ServletContext context = httpSessionBindingEvent.getSession().getServletContext();
        String sessionID = httpSessionBindingEvent.getSession().getId();
        if("name".equals(name)){
            // 2.1 获取context域中map集合
            Map<String,HttpSession> onLine =
                    (Map<String,HttpSession>) context.getAttribute("onLine");
            // 2.2 移除对应的session对象
            onLine.remove(sessionID);
            // 2.3 修改后的map保存到context域中
            context.setAttribute("onLine",onLine);
        }

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
