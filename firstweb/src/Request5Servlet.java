import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class Request5Servlet extends HttpServlet {
    /*
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("Request5Servlet"); // 字符流
        resp.getOutputStream().write("Request5Servlet".getBytes());   // 字节流
        // 1. resp 响应对象修改响应数据
        // 1.1 响应行
        // resp.setStatus(404);    // 404状态码
        // resp.sendError(404);    //  404+404页面
        // 1.2 响应头
        // resp.setHeader("server","webLogic");
        // 1.3 实体内容
        // resp.getOutputStream().write("浏览器主题看到的内容".getBytes());
        // 2. tomcat服务器把response对象转换成响应格式的字符串,发送给浏览器
    }
    */

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        *//*resp.setStatus(302);    // 302状态码
        resp.setHeader("location","/test.html");  // location 响应头*//*
        resp.sendRedirect("/test.jsp"); // 同上面 两行
    }*/

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 定时刷新
        *//*resp.setHeader("refresh","2");    // 每隔两秒刷新
        resp.getWriter().write(""+new Date());*//*
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("注册成功 3秒后跳转到主页");
        resp.setHeader("refresh","3;/index.html");
    }*/

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 数据类型和数据编码格式
        *//*resp.setHeader("content-type","text/html; charset=UTF-8");// 两个等价
        resp.setContentType("text/html; charset=UTF-8");        *//*
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>html标题</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>数据类型和数据编码格式</h1>\n" +
                "</body>\n" +
                "</html>");
    }*/

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 文件下载
        resp.setHeader("content-disposition","attachment;filename=aqie.jpg");
        // 读取本地文件
        resp.setContentType("image/jpg"); // 设置返回的文件类型
        FileInputStream fileInputStream = new FileInputStream("D:\\coreJava\\myServlet\\firstweb\\web\\avatar.jpg");
        ServletOutputStream outputStream = resp.getOutputStream();     // 字节内容
        int len = 0;
        byte[] buff = new byte[1024];
        // 边读边写
        while((len = fileInputStream.read(buff)) != -1){
            outputStream.write(buff,0,len);
        }
        outputStream.close();
        fileInputStream.close();
    }
}

