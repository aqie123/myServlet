package FileUpload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MysqlUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tempDirectory = "D:\\coreJava\\myServlet\\firstweb\\web\\staticFile\\temp";
        DiskFileItemFactory factory = new DiskFileItemFactory(10*1024,new File(tempDirectory));
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 1.中文文件名
        upload.setHeaderEncoding("utf-8");
        // 2. 限制文件大小
        upload.setFileSizeMax(100*1024);
        upload.setSizeMax(500*1024);

        // 解析
        try {
            List<FileItem> list = upload.parseRequest(req);
            FileBeanDao dao = new FileBeanDao();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            List<FileBean> fileBeanList = new ArrayList<>();

            if(list != null){
                FileBean bean = null;
                // 遍历每个文件
                for(FileItem fileItem : list){
                    bean = new FileBean();
                    if(fileItem.isFormField()){     // 普通文件
                        bean.setInfo(fileItem.getString("utf-8"));
                        fileBeanList.add(bean);
                        // 7.保存到数据库
                        dao.saveFile(bean);
                    }else {
                        // 1. 文件保存到服务器硬盘
                        String uuid = UUID.randomUUID().toString();
                        String fileName = fileItem.getName();
                        long size = fileItem.getSize();     // 文件大小
                        // 2.后缀 随机文件名，防止重复
                        fileName = uuid + fileName.substring(fileName.lastIndexOf("."));
                        // 3.得到web应用目录中绝对路径(D:\coreJava\myServlet\firstweb\web\staticFile\Uploads)
                        String baseDir = this.getServletContext().getRealPath("staticFile/Uploads");
                        String subDir = makeDirectory(fileName);
                        String finalDir = baseDir + "/" + subDir;
                        FileUtils.copyInputStreamToFile(fileItem.getInputStream(), new File(finalDir + fileName));

                        // 4.计算文件大小
                        String sizeStr = calculateFileSize(size);
                        // 5.封装到FileBean对象中

                        bean.setName(fileName);
                        bean.setSize(sizeStr);
                        bean.setAddTime(sdf.format(new Date()));
                        bean.setFile_path("/staticFile/Uploads" + "/" + subDir + fileName);
                        // 6.删除临时文件
                        fileItem.delete();
                    }

                }
                // 将完成的文件信息转发到jsp页面
                req.setAttribute("fileList",fileBeanList);
                req.getRequestDispatcher("/fileUpload/uploadSuccess.jsp").forward(req,resp);
            }
        } catch(FileUploadBase.FileSizeLimitExceededException e){   // 每个文件限制
            req.setAttribute("msg","每个文件不能超过100k");
            req.getRequestDispatcher("/fileUpload/mysqlUpload.jsp").forward(req,resp);
        } catch(FileUploadBase.SizeLimitExceededException e){       // 总文件限制
            req.setAttribute("msg","总文件不能超过500k");
            req.getRequestDispatcher("/fileUpload/mysqlUpload.jsp").forward(req,resp);
        }catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    private String calculateFileSize(long size) {
        String sizeStr = "";
        if(size>=1024 && size<1024*1024){
            sizeStr = (size/1024.0)+"KB";
        }else if(size>1024*1024 && size<=1024*1024*1024){
            sizeStr = (size/(1024*1024.0))+"MB";
        }else if(size >= 1024*1024*1024){
            sizeStr = (size/(1024*1024.0*1024))+"GB";
        }else{
            sizeStr = size+"B";
        }
        return sizeStr;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private String makeDirectory(String fileName){
        int code = fileName.hashCode();
        int first = code & 0xFF;
        int second = code & (0xFF>>1);
        return first+"/"+second+"/";
    }
}
