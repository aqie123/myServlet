package sessionLogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 管理员踢出在线用户
 */
public class KickOutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收踢出id
        String sessionID = req.getParameter("sessionID");
        // 2.强制注销用户
        Map<String,HttpSession> onLine =
                (Map<String, HttpSession>) this.getServletContext().getAttribute("onLine");
        // 2.1查询需要注销的session对象
        HttpSession session = onLine.get(sessionID);
        if(session != null){
            session.removeAttribute("name");
            session.removeAttribute("ip");
        }
        // 注意这里跳转路径
        resp.sendRedirect(req.getContextPath()+"/session/getOnline");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
