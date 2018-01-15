package sessionLogin;

import javax.servlet.*;
import java.io.IOException;

public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        String ip = servletRequest.getRemoteHost();
        if("localhost".equals(ip) || "127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)){
            // 管理员
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            // 权限不足
            servletResponse.getWriter().write("权限不足，无法删除");
        }

    }

    @Override
    public void destroy() {

    }
}
