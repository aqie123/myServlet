package MailRegister;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * 邮箱激活用户注册 逻辑
 * 1. 检查随机激活码是否存在
 * 2. 检查是否超过48小时
 * 3. 检查邮箱是否正确
 * 4. 激活用户,修改user_list表status 状态为 1
 */
public class MailActiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收用户发送的参数
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        // 2.检查随机码激活是否存在
        UserService service = new UserService();
        User_list user = service.queryUser(code);
        if(user != null){
            // 3.检查是否超过48小时 (计算最后过期时间)
            Date currentTime = new Date();          // 当前时间
            Date regTime = user.getCreate_time();   // 用户注册时间
            Date lastTime = calculateLastTime(regTime);
            if(lastTime.after(currentTime)){
                // 4.检查邮件是否正确
                if(user.getEmail().equals(email)){
                    // 5. 激活用户
                    service.active(user.getId());
                    req.setAttribute("msg","激活成功，请到登录页面登录");
                    req.getRequestDispatcher("/mailRegister/regMessage.jsp").forward(req,resp);
                    return;
                }else {
                    // 邮箱不存在
                    req.setAttribute("msg","邮箱不存在");
                    req.getRequestDispatcher("/mailRegister/regMessage.jsp").forward(req,resp);
                    return;
                }
            }else {
                // 已经过期
                req.setAttribute("msg","激活时间已经过期");
                req.getRequestDispatcher("/mailRegister/regMessage.jsp").forward(req,resp);
                return;
            }

        }else{
            // 随机码不存在
            req.setAttribute("msg","随机验证码不存在");
            req.getRequestDispatcher("/mailRegister/regMessage.jsp").forward(req,resp);
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    /**
     * 计算最后过期时间
     */
    private Date calculateLastTime(Date regTime){
        // 日历对象
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(regTime);
        // 时间+2天
        calendar.add(Calendar.DATE,2);
        return calendar.getTime();
    }
}
