package context;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;


public class ContextServlet extends HttpServlet{

    /*
    // 1.获取web上下文路径
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取ServletContext对象
        // this.getServletConfig().getServletContext();  下面简写
        ServletContext context = this.getServletContext();
        // 2.
        String path = context.getContextPath();
        System.out.println("ServletContext对象");
        System.out.println(path);

        // 请求重定向
        //resp.sendRedirect("/hello");
    }*/

    /*
    // 2.获取全局参数
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        // 获取单个参数
        System.out.println(context.getInitParameter("AAA"));
        // 遍历所有参数
        Enumeration<String> enumeration = context.getInitParameterNames();
        while(enumeration.hasMoreElements()){
            String paramName = enumeration.nextElement();
            String paramValue = context.getInitParameter(paramName);
            System.out.println(paramName+":"+paramValue );
        }
    }*/

    /*
    // 3.数据存储到ServletContext域对象
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        context.setAttribute("name","aqie");
        System.out.println("保存成功");
    }*/

    /*
    // 4.请求转发
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/hello");
        rd.forward(req,resp);
    }*/

    // 5.读取web项目资源文件 读取properties文件
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 相对路径：当前相对路径相对于java命令运行的目录
         * 在web项目中,java命令运行的目录就是在tomcat的bin目录
         * D:\Program Files\apache-tomcat-8.5.24\bin\.
         * 结论：在web项目中不能使用相对路径
         */
        // 5.1 获取资源文件真实路径
        String fileName = "/WEB-INF/classes/news.properties";
        String path = this.getServletContext().getRealPath(fileName);
        System.out.println(path);

        // 5.3 获取资源文件的url
        URL url = this.getServletContext().getResource(fileName);
        String path2 = url.getPath();
        System.out.println("获取资源文件的url"+url);
        System.out.println(path2);
        FileInputStream in = new FileInputStream(path2);   // 常规获取方法 (path path2 一样的)


        // 5.2 获取资源文件的输入流
        // InputStream in = this.getServletContext().getResourceAsStream(fileName);

        // 1. 使用properties对象
        Properties p = new Properties();
        // 2.加载properties文件
        p.load(in);
        // 3. getProperty()读取内容
        System.out.println(p.getProperty("myname"));
        System.out.println(p.getProperty("password"));

        File file = new File(".");
        System.out.println(file.getAbsoluteFile());




    }
}
