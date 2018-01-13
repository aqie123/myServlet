package compression;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class ContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 准备内容
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<=3000;i++){
            stringBuffer.append("abcd");
        }
        // 压缩前 11.8kb 12004
        System.out.println("压缩前数据大小"+stringBuffer.toString().getBytes().length);
        // gzipCompress(resp, stringBuffer);

        /** 加过滤器后,每次写出到网页内容都是经过gzip压缩的内容
         *  1.response 对象的getWriter() 方法得到的是没有缓冲的PrintWriter 的writer方法
         *  调用writer()方法就是直接把内容输出到浏览器
         *  2. 解决：改造response对象的getWriter方法,得到一个带缓存功能的PrintWriter对象
         *  writer写出到网页内容就是直接写出到PrintWriter缓存区内,
         *  从PrintWriter缓存区中得到网页内容
         */
        resp.getWriter().write(stringBuffer.toString()); // 压缩前内容输出到浏览器
    }

    private void gzipCompress(HttpServletResponse resp, StringBuffer stringBuffer) throws IOException {
        // gzip 对网页压缩
        // 1. 创建临时的缓存容器
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        // 2. 创建GZIPOutputStream
        GZIPOutputStream gzip = new GZIPOutputStream(buff);
        // 3.进行压缩
        gzip.write(stringBuffer.toString().getBytes());
        // 4. 调用结束方法将缓存刷新
        gzip.finish();
        // 5. 得到压缩后内容
        byte[] result = buff.toByteArray();
        System.out.println("压缩后数据大小 ："+result.length);

        /**
         * 压缩后内容输出到浏览器
         * 必须告诉浏览器当前内容是gzip压缩后内容
         */
        resp.setHeader("Content-Encoding","gzip");
        resp.getOutputStream().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
