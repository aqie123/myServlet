package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

// 记录上次访问时间
public class LastAccessTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 获取cookie
        Cookie[] cookies = req.getCookies();
        String lastTime = null;
        if(cookies != null){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("lastTime")){
                    String currDate = currTime();

                    lastTime = cookie.getValue();
                    // 对日期字符串解密
                    lastTime = URLDecoder.decode(lastTime,"utf-8");
                    resp.getWriter().write("欢迎登录,当前时间"+currDate);
                    resp.getWriter().write("<br/>欢迎登录,上次登录时间"+lastTime);
                    // 并将当前时间写入到cookie
                    currDate = URLEncoder.encode(currDate,"utf-8");
                    cookie.setValue(currDate);
                    resp.addCookie(cookie);
                    break;
                }
            }
        }

        // 首次登录
        if(cookies == null || lastTime == null){
            String currDate = currTime();
            // 2.显示到browser
            resp.getWriter().write("欢迎登录,当前时间"+currDate);
            // 3.把当前时间保存到cookie中
            // 4.对中文格式的日期字符串加密
            currDate = URLEncoder.encode(currDate,"utf-8");
            Cookie c = new Cookie("lastTime",currDate);
            // 5.cookie发送给浏览器
            resp.addCookie(c);
        }
    }

    private String currTime() {
        // 1.制作当前登录时间字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currDate = sdf.format(new Date());
        return currDate;
    }
}
