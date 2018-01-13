package MyFilter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class FirstFilter implements Filter{
    public FirstFilter(){
        System.out.println("1).create Filter Object!");
    }

    /**
     * FilterConfig 封装了所有当前过滤器初始配置参数
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2).Filter init !");
        System.out.println(filterConfig.getInitParameter("aqie"));
        // 遍历所有参数
        Enumeration<String> enumeration = filterConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()){
            String paramName = enumeration.nextElement();

            String paramValue = filterConfig.getInitParameter(paramName);
            System.out.println(paramName+" : "+paramValue);
        }
    }


    /**
     * 执行过滤任务
     * FilterChain 过滤器链对象
     * doFilter 将请求或响应交给下一个过滤器,无下个过滤器则访问目标资源
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
