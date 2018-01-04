package login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(false);
        // 将整个session对象注销,session对象中所有数据都不可用
        if(session!=null){
            session.removeAttribute("user");

            resp.getWriter().write("注销成功 <a href='"+req.getContextPath()+
                    "/login.html'>返回登录登录</a>");
        }
    }
}
