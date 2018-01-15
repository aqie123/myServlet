package FileUpload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class FileUpload2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.创建文件上传工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.创建文件上传核心类对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 3.设置单个文件最大30M
        upload.setFileSizeMax(30*1024*1024);//30M
        // 4.设置总文件大小：50M
        upload.setSizeMax(50*1024*1024); //50M
        upload.setHeaderEncoding("utf-8");
        // 5.判断，当前表单是否为文件上传表单
        if(upload.isMultipartContent(req)){
            try{
                // 6.把请求数据转换为FileItem对象的集合
                List<FileItem> list = upload.parseRequest(req);
                // 7.遍历,得到每一个上传项
                for(FileItem item : list){
                    if(item.isFormField()){       // 普通表单
                        String fieldName = item.getFieldName();//获取元素名称
                        String value = item.getString("UTF-8"); //获取元素值
                        System.out.println(fieldName+" : "+value);
                    }else {                      // 文件上传表单
                        String name = item.getName();   //上传的文件名称
                        long size = item.getSize();     // 文件大小
                        String contentType = item.getContentType(); // 文件类型
                        // 8.随机生成一个唯一标记
                        String id = UUID.randomUUID().toString();
                        name += id;
                        // 9.上传文件到指定目录
                        String realPath = getServletContext().getRealPath("/staticFile/Uploads");
                        // 10. 创建文件对象
                        File file = new File(realPath,name);
                        item.write(file);
                        item.delete();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("不处理");
        }
    }
}
