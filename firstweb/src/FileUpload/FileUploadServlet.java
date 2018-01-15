package FileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

// Manual parsing Upload Files
public class FileUploadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取所有上传信息
        InputStream in = req.getInputStream();
        // 转换流 + 缓冲流  (字节输入流  转换为 字符输入流)
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        // 文件开始分隔符
        String fileTag = br.readLine();
        String str = br.readLine();
        // 获取上传文件名
        String fileName = str.substring(str.indexOf("filename=\"")+10,str.length()-1);

        br.readLine();
        br.readLine();
        String content = null;
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\coreJava\\myServlet\\firstweb\\staticFile\\Uploads\\"+fileName));
        while((content = br.readLine()) != null){
            // 排除文件结束符号
            if(content.equals(fileTag+"--")){
                continue;
            }
            bw.write(content);
            // 写入换行符
            // bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
