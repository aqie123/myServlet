import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Request3Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // resp.getWriter().write("Downloading ...");
        String referer = req.getHeader("referer");
        System.out.println("referer= "+referer);
        /**
         * 判断非法请求
         *      1).直接访问(referer = null)
         *      2).当前请求不是来自广告页面(!referer.contains("adv.html"))
         */
        if(referer ==null || referer.contains("adv.html")){
            resp.getWriter().write("请求非法");
        }else{
            resp.getWriter().write("Downloading ...");
        }
    }
}
