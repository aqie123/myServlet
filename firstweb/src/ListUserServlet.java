import login.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.查询用户数据
        List<User> list = new ArrayList<>();
        list.add(new User("aqie"));
        list.add(new User("bqie"));
        list.add(new User("cqie"));

        // 2.list数据保存到域对象
        /**
         * context 域
         * Request 域 ：必须使用转发
         * session 域
         */
        req.setAttribute("list",list);
        // 3.转发
        req.getRequestDispatcher("/learn/user.jsp").forward(req,resp);
    }
}
