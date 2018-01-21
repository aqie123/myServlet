package fileDownload;

import FileUpload.FileBean;
import FileUpload.FileBeanService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 数据库下载文件
 */
public class MysqlDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        FileBeanService service = new FileBeanService();
        if(idStr != null && !idStr.equals("")){
            int id = Integer.parseInt(idStr);
            FileBean bean = service.findById(id);
            String fileName = bean.getName();
            String path = bean.getFile_path();
            InputStream in = this.getServletContext().getResourceAsStream(path);
            fileName = URLEncoder.encode(fileName,"utf-8");
            String userAgent = req.getHeader("user-agent");
            String content = "";
            if(userAgent.contains("Trident")){
                content = "attachment;filename="+fileName;
            }else{
                content = "attachment;filename*="+fileName;
            }
            resp.setHeader("content-disposition", content);

            OutputStream outputStream = resp.getOutputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while((len = in.read(buff)) != -1){
                outputStream.write(buff,0,len);
            }
            outputStream.close();
            in.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
