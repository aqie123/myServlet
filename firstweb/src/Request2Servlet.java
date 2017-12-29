import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Request2Servlet extends HttpServlet {
    @Override
    /**
     *  servlet核心服务方法,业务逻辑在这里触发,
     *  是一个入口
     *  HttpServlet中service,根据不同请求方式调用不同doGet/doPost
     *  一般只需要覆盖 写doGet/doPost就可以
     */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAgent = req.getHeader("user-agent");
        System.out.println("USER-AGENT:" + userAgent);
        System.out.println("Service 啊切");
        if(userAgent.contains("Firefox")){
            resp.getWriter().write("Firefox");
        }else if(userAgent.contains("Chrome")){
            resp.getWriter().write("Chrome");
        }else if(userAgent.contains("Trident")){
            resp.getWriter().write("Trident");
        }
    }
}
