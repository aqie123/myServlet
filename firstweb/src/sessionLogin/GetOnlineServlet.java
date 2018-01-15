package sessionLogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  将存储的map集合登录用户信息,转换到List<OnLineBean>集合
 */
public class GetOnlineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 从context域中取出map 集合
        Map<String,HttpSession> onLine = (Map<String,HttpSession>)
                this.getServletContext().getAttribute("onLine");
        // 2. 创建一个新的List集合
        List<OnLineBean> list = new ArrayList<>();
        // 3.遍历map集合
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 封装用户信息到javabean
        if(onLine != null) {
            synchronized (GetOnlineServlet.class) {
                for (Map.Entry<String, HttpSession> entry : onLine.entrySet()) {
                    OnLineBean bean = new OnLineBean();
                    bean.setSessionID(entry.getKey());
                    HttpSession session = entry.getValue();
                    bean.setName((String) session.getAttribute("name"));
                    bean.setIp((String) session.getAttribute("ip"));
                    bean.setLoginTime(sdf.format(new Date(session.getCreationTime())));
                    bean.setLastTime(sdf.format(new Date(session.getLastAccessedTime())));
                    list.add(bean);
                }
            }
        }
        // 把list转发到jsp页面
        req.setAttribute("list",list);
        req.getRequestDispatcher("/sessionLogin/online.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
