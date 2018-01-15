package sessionLogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 在线用户登录逻辑
public class SessionLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.设置编码
        req.setCharacterEncoding("utf-8");
        // 2.接收参数
        String name = req.getParameter("name");
        // 3.登陆成功保存用户信息到session域中
        HttpSession session = req.getSession(true);
        /**
         * 编写 HttpSession 属性监听器OnLineListener,用于监听name属性名称增加
         */
        session.setAttribute("name",name);
        session.setAttribute("ip",req.getRemoteHost());
        // 4.跳转到用户登录主页
        resp.sendRedirect(req.getContextPath()+"/sessionLogin/userInfo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
