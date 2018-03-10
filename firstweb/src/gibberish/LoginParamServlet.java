package gibberish;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决post 提交参数乱码
        /*if("POST".equals(req.getMethod())){
            req.setCharacterEncoding("utf-8");
        }*/
        // 接收login.html 提交参数 解决中文乱码
        /**
         *  业务的servlet 调用Request的getParameter方法前,重写
         *  getParameter方法,重写之后获取参数都是经过正确转码内容
         *  重写 HttpServletRequest对象的getParameter方法
         */
        String userName = req.getParameter("name");
        // 解决get 提交参数乱码 手动解码
        /*if("GET".equals(req.getMethod())){
            userName = new String(userName.getBytes("iso-8859-1"),"utf-8");
        }*/
        System.out.println(userName);
        System.out.println("姓名");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
