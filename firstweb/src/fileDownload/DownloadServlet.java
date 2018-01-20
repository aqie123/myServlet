package fileDownload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String relativePath = "staticFile/Uploads/";
        String fileName = "啊切.jpg";
        String content = "";

        // 1.读取服务器文件
        InputStream in = this.getServletContext().getResourceAsStream(relativePath+fileName);
        // 2.对中文名加入URLEncoder加密
        fileName = URLEncoder.encode(fileName,"utf-8");

        // 3.设置响应头,告诉浏览器以下载方式打开,并判断浏览器是否为IE
        String userAgent = req.getHeader("user-agent");
        if(userAgent.contains("Trident")){
            content = "attachment;filename="+fileName;
        }else{
            content = "attachment;filename*="+fileName;
        }

        resp.setHeader("content-disposition", content);

        // 4.把文件内容发送给浏览器
        OutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while((len = in.read(buff)) != -1){
            outputStream.write(buff,0,len);
        }
        outputStream.close();
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
