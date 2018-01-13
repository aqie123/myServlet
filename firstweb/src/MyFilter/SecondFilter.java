package MyFilter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class SecondFilter implements Filter{
    public SecondFilter(){
        System.out.println("1).create Second Filter Object!");
    }

    /**
     * FilterConfig 封装了所有当前过滤器初始配置参数
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2).Second Filter init !");
    }


    /**
     * 执行过滤任务
     * FilterChain 过滤器链对象
     * doFilter 将请求或响应交给下一个过滤器,无下个过滤器则访问目标资源
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3).execute Second Filter task! 过滤请求");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("5). execute Second Filter task! 过滤响应 ");
    }

    // web项目重新部署,tomcat服务器停止才会销毁
    @Override
    public void destroy() {
        System.out.println("过滤器对象被销毁");
    }
}
