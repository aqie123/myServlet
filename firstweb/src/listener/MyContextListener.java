package listener;

import javax.servlet.*;

/**
 * ServletContext 监听器
 * 需求：在项目启动时，初始化表
         项目结束，删除表
 */
public class MyContextListener implements ServletContextListener,ServletContextAttributeListener{
    SystemDao dao = new SystemDao();
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("create Context Object");
        dao.initTable();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("destory Context Object");
        dao.clearTable();
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("add Attribute");
        // 得到属性名
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println("属性添加 "+name+":"+value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("remove Attribute");
        String name = servletContextAttributeEvent.getName();
        System.out.println("属性删除 "+name);
    }

    /**
     * 已经包含了事件源对象
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("replace Attribute");
        String name = servletContextAttributeEvent.getName();
        // 得到修改前的值
        Object value = servletContextAttributeEvent.getValue();
        // 得到修改后的值(需要从ServletContext事件源再次获取属性,才能得到最新的属性值)
        ServletContext context = servletContextAttributeEvent.getServletContext();
        Object value2 = context.getAttribute(name);
        System.out.println("属性修改 "+name+":"+value+" : "+value2);
    }
}
