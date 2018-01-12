package MyFilter;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter{
    public FirstFilter(){
        System.out.println("1).create Filter Object!");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2).Filter init !");
    }

    /*
        执行过滤任务
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3).execute Filter task! 过滤请求");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("5). execute Filter task! 过滤响应 ");
    }

    // web项目重新部署,tomcat服务器停止才会销毁
    @Override
    public void destroy() {
        System.out.println("过滤器对象被销毁");
    }
}
