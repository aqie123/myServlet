package session;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

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
        Cookie c = new Cookie("name","aqie123");
        // 2.通过响应头携带cookie数据给浏览器
        resp.setHeader("set-cookie","name=aqie123");
        // 3. 浏览器下次访问携带cookie数据,通过请求头发送给服务器(cookie)
        String cookie = req.getHeader("cookie");
        // 4. 获取cookie值
        System.out.println(cookie);
    }
}
