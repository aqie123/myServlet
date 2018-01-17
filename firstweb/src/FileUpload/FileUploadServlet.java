package FileUpload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

// Manual parsing Upload Files
public class FileUploadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // MyParseUpload(req);
        String tempDirectory = "D:\\coreJava\\myServlet\\firstweb\\web\\staticFile\\temp";
        fileUpload(req,resp,tempDirectory);

    }

    // 多文件fileUpload上传 (同时封装到fileBean)
    private void fileUpload(HttpServletRequest req,HttpServletResponse resp,String tempDirectory) {
        /** 1.创建文件上传工厂类，设置
         *  缓存大小: 文件不够缓存大小，文件直接传到服务器,不通过缓存
         *          否则,文件先存到缓存目录,再从缓存目录转移到指定保存目录中
         *  缓存目录: 提供给缓存文件存储的地址
         */
        // 10kb
        // DiskFileItemFactory factory = new DiskFileItemFactory();
        DiskFileItemFactory factory = new DiskFileItemFactory(10*1024,
                new File(tempDirectory));
        //2.创建文件上传核心类对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 3.设置单个文件最大30M
        upload.setFileSizeMax(30*1024*1024);//30M
        // 4.设置总文件大小：50M
        upload.setSizeMax(50*1024*1024); //50M
        // upload.setHeaderEncoding("utf-8");

        if(upload.isMultipartContent(req)){
            try{
                // 6.把请求数据转换为FileItem对象的集合
                List<FileItem> list = upload.parseRequest(req); // 自动读取请求实体内容所有上传文件信息
                List<FileBean> fileList = new ArrayList<>();
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
                        /**
                         * 封装文件信息
                         */
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        FileBean bean = new FileBean();
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
                        bean.setName(name);
                        bean.setSize(sizeStr);
                        bean.setType(contentType);
                        bean.setAddTime(sdf.format(new Date()));
                        fileList.add(bean);

                        // 8.随机生成一个唯一标记
                        String id = UUID.randomUUID().toString();
                        // 9.文件内容
                        InputStream in = item.getInputStream();
                        // 使用IO流工具,写入到硬盘
                        FileUtils.copyInputStreamToFile(in,new File("D:\\coreJava\\myServlet\\firstweb\\web\\staticFile\\Uploads\\"+name));
                        // 文件上传成功，删除临时文件
                        item.delete();

                    }
                }
                // 跳转到成功页面,显示成功的所有文件
                req.setAttribute("fileList",fileList);
                req.getRequestDispatcher("/fileUpload/uploadSuccess.jsp").forward(req,resp);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("不处理");
        }
    }

    // 手动解析文件上传
    private void MyParseUpload(HttpServletRequest req) throws IOException {
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

            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public void getPath(){
        String realPath = getServletContext().getRealPath("staticFile");
        System.out.println(realPath);
    }
}
