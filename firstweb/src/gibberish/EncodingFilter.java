package gibberish;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        // 强制转换
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        // 创建一个HttpServletRequest实现类的装饰者类,重写getParameter
        MyHttpRequest myHttpRequest = new MyHttpRequest(req);
        /*
        String userName = req.getParameter("name");
        // 解决post提交参数 乱码
        if("POST".equals(req.getMethod())){
            servletRequest.setCharacterEncoding("utf-8");
        }
        // 解决get提交参数乱码
        if("GET".equals(req.getMethod())){
            userName = new String(userName.getBytes("iso-8859-1"),"utf-8");
        }*/
        /**
         * 放行装饰后的请求对象
         */
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

/**
 * 装饰者类
 */
class MyHttpRequest extends HttpServletRequestWrapper{
    // 1.声明一个被装饰者类成员变量
    private HttpServletRequest request;
    // 2.接收被装饰者类对象
    public MyHttpRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }
    // 3.重写getParameter方法

    @Override
    public String getParameter(String name) {

        // 处理get参数
        String value = request.getParameter("name");

        try {
            if("GET".equals(request.getMethod())) {
                value = new String(value.getBytes("iso-8859-1"), "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        // 处理post参数
        return value;
    }
}
