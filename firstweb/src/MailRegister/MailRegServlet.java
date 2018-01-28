package MailRegister;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * 处理注册逻辑
 *  1.保存用户信息
 *  2.给用户发送激活邮件
 *  3.
 */
public class MailRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1.接收数据
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        // 2.保存数据到对象
        User_list user = new User_list();
        user.setId(WebUtil.uuid());
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setCreate_time(new Date());    // 注册时间
        user.setValidateCode(WebUtil.uuid());

        // 3.调用业务方法,保存用户信息
        UserService service = new UserService();
        service.reg(user);

        // 4.使用线程发送邮件
        new MySendMailThread(user).start();

        // 5.回显给用户
        resp.sendRedirect(req.getContextPath()+"/mailRegister/regSuccess.jsp");
        System.out.println("mail register");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}

// 使用线程发送邮件
class MySendMailThread extends Thread{
    private User_list user;
    public MySendMailThread(User_list user){
        this.user = user;
    }

    @Override
    public void run() {
        try{
            Properties props = new Properties();
            props.setProperty("mail.host", "smtp.163.com");
            props.setProperty("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("aqie123aqie@163.com","aqie123aqie");
                }
            });
            session.setDebug(true);
            MimeMessage mail = new MimeMessage(session);
            mail.setFrom(new InternetAddress("aqie123aqie@163.com"));
            mail.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail()));
            mail.setSubject("aqie 网站java 注册邮件");
            String html = "亲爱的"+user.getName()+"用户:<br/>&nbsp;&nbsp;恭喜你成为在线学习系统的会员，请于48小时内使用以下链接激活你的用户。<br/>";

            html += "<a href='http://192.168.0.135:8080/mailActive?email="+user.getEmail()+"&code="+user.getValidateCode()+"'>激活链接</a>";
            mail.setContent(html,"text/html;charset=utf-8");
            Transport.send(mail);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}