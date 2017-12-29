import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class RequestServlet extends HttpServlet {
    // 只能接受get提交的参数
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 请求数据
        // t1(req);
        System.out.println("获取所有头名称");
        Enumeration<String> enumeration = req.getHeaderNames();
        // 遍历所有头
        while(enumeration.hasMoreElements()){
            String headerName = enumeration.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName+":"+headerValue);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 3. 实体内容(post提交参数才会出现在实体内容中)
        InputStream inputStream = req.getInputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while((len = inputStream.read()) != -1){
            String string = new String (buff,0,len);
            System.out.println(string);
        }
    }

    private void t1(HttpServletRequest req) {
        // 1.1请求方式
        System.out.println("请求方式"+req.getMethod());
        // 1.2请求资源
        System.out.println("URL"+req.getRequestURL());
        System.out.println("URI"+req.getRequestURI());
        // 1.3 http协议版本
        System.out.println("http协议"+req.getProtocol());
        // 2. 请求头
        System.out.println("host"+req.getHeader("host"));
    }
}
