package login;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录权限过滤器
 */
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        // 是否登录判断逻辑
        // 先判断是否有session对象存在
        HttpSession session = request.getSession(true);
        if(session == null){
            // 未登录
            response.sendRedirect(request.getContextPath()+"/noAuth.jsp");
            return;
        }else{
            String user = (String)session.getAttribute("name");
            if(user == null){       // 未登录
                response.sendRedirect(request.getContextPath()+"/noAuth.jsp");
                return;
            }
        }
        // 如果已经登录成功,则放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
