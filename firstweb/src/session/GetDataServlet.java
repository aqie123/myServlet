package session;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class GetDataServlet extends HttpServlet {
    /*
    // 接收post data
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取实体内容
        InputStream inputStream = req.getInputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while((len=inputStream.read(buff)) != -1){
            String str = new String(buff,0,len);
            System.out.println(str);
            str = URLDecoder.decode(str,"utf-8");
            System.out.println(str);
        }
    }*/

    // 使用cookie

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.创建 cookie对象
        String n = URLEncoder.encode("啊切","utf-8"); // 中文先加密在解密
        Cookie c = new Cookie("name",n);
        Cookie c2 = new Cookie("name2","aqie2");
        // 2.通过响应头携带cookie数据给浏览器
        // resp.setHeader("set-cookie","name=aqie123");
        // 简化
        resp.addCookie(c);
        resp.addCookie(c2);
        // 3. 浏览器下次访问携带cookie数据,通过请求头发送给服务器(cookie)
        // String cookie = req.getHeader("cookie");
        // 简化
        Cookie[] cookies = req.getCookies();
        // 4. 获取cookie值
        if(cookies != null){
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                value = URLDecoder.decode(value,"utf-8");
                System.out.println(name+":"+value);
            }
        }else{
            System.out.println("没有cookie信息");
        }
    }
}
