package sessionLogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 在线用户注销逻辑
 */
public class SessionLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 删除登陆成功时 保存在session域中对象
        HttpSession session = req.getSession(false);
        if(session != null){
            session.removeAttribute("name");
            session.removeAttribute("ip");
        }

        resp.sendRedirect(req.getContextPath()+"/sessionLogin/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
