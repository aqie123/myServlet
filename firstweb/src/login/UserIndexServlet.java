package login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = null;
        if(session == null){
            resp.sendRedirect(req.getContextPath()+"/login.html");
            return;
        }else{
            user = (User)session.getAttribute("user");
            if(user == null){
                resp.sendRedirect(req.getContextPath()+"/login.html");
                return;
            }
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("登陆成功: "+user.getName());
        resp.getWriter().write("<a href='"+req.getContextPath()+
                "/logout'>注销</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
