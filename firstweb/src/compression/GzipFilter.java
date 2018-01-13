package compression;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * 集中对网页内容 gzip压缩
 */
public class GzipFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.过滤请求
        // 创建一个response的装饰者对象
        MyHttpResponse myHttpResponse = new MyHttpResponse((HttpServletResponse) servletResponse);
        // 放行
        filterChain.doFilter(servletRequest,myHttpResponse);

        // 过滤响应
        // 从缓存容器对象得到要被压缩内容(response对象无法获取实体内容)
        char[] content = myHttpResponse.getCharArray();
        // gzip 压缩
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(buff);
        gzip.write(new String(content).getBytes());
        gzip.finish();
        byte[] result = buff.toByteArray();
        myHttpResponse.setHeader("Content-Encoding","gzip");
        // 输出
        myHttpResponse.getOutputStream().write(result);
        // myHttpResponse.getWriter();
    }

    @Override
    public void destroy() {

    }
}

// HttpServletResponse 的装饰器类
class MyHttpResponse extends HttpServletResponseWrapper{
    private HttpServletResponse response;
    // 定义一个缓存容器对象
    private CharArrayWriter charArray = new CharArrayWriter();
    // 提供获取charArray内容方法(包含网页内容)
    public char[] getCharArray(){
        return charArray.toCharArray();
    }
    public MyHttpResponse(HttpServletResponse response) {
        super(response);
        this.response = response;
    }
    // 重写getWriter()方法,让其返回带缓冲功能的PrintWriter

    @Override
    public PrintWriter getWriter() throws IOException {
        /** 创建一个带CharArrayWriter缓存容器的PrintWriter
            调用带缓存PrintWriter对象的write()方法,内容会
            直接写入到CharArrayWriter缓存容器中
            改变 ContentServlet中的response对象
         */
        return new PrintWriter(charArray);
    }
}
