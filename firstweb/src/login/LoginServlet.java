package login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // xmlLogin(req, resp);  // xml文件验证登录
        sessionCheckLogin(req, resp);

    }

    private void sessionCheckLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        // 判断登录
        if("aqie".equals(name) && "123".equals(password)){
            // 将用户数据保存到session
            HttpSession session = req.getSession(true);
            session.setAttribute("name",name);
            // 跳转到用户主页
            resp.sendRedirect(req.getContextPath()+"/user/modify.jsp");
        }else{
            resp.getWriter().write("用户名或密码错误");
            // 转发
            req.getRequestDispatcher("/user/login.html").forward(req,resp);
        }
    }

    private void xmlLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 接收post数据
        req.setCharacterEncoding("utf-8");      // post提交的参数中文乱码
        resp.setContentType("");                // 解码输出数据的中文乱码
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        // 与数据库(xml)文件对比
        UserDao dao = new UserDao();
        User user = dao.findByName(name);
        if(user != null){
            if(password.equals(user.getPassword())){
                // 登陆成功
                // 跳转到用户主页
                // 记录session
                HttpSession session = req.getSession(true);
                session.setAttribute("user", user);
                // 使用重定向
                resp.sendRedirect(req.getContextPath()+"/userInfo");
                // 跳转记录session
            }else{
                resp.getWriter().write("密码错误");
            }
        }else{
            // 提示密码错误
            resp.getWriter().write("该用户不存在");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
