import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class Request4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("Request4Servlet-GET \n\r");
        // 获取get参数
        resp.getWriter().write("获取get参数 : "+req.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("Request4Servlet-POST \n\r");
        // 获取post参数(实体内容)
        // resp.getWriter().write("获取post参数 : "+req.getQueryString());
        ServletInputStream servletInputStream = req.getInputStream();
        byte[] buff = new byte[1024];
        int length = 0;
        while ((length = servletInputStream.read()) != -1){
            String str = new String(buff,0,length);
            System.out.println(str);
        }


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通用方法
        String name = req.getParameter("name");
        // 获取所有参数名称列表
        Enumeration<String> enumeration = req.getParameterNames();
        while (enumeration.hasMoreElements()){
            String paramName = enumeration.nextElement();
            String paramValue = req.getParameter(paramName);
            System.out.println(paramName+":"+paramValue);
        }

        System.out.println("==============");
        // 获取参数对象列名(Map集合) 键值.每个map对象就是一个参数(参数名 参数值)
        Map<String,String[]> map = req.getParameterMap();
        // 方式一 Entry对象包含一个键对象和一个值对象
        /*Set<Map.Entry<String,String[]>> entrySet = map.entrySet();
        for (Map.Entry<String,String[]> entry : entrySet
             ) {
            // 获取键对象
            String key = entry.getKey();
            // 获取值对象
            String[] value = entry.getValue();
            System.out.println(key+":"+value);
        }*/

        // 方式二 KeySet() 获取所有键对象的Set集合
        /*Set<String> keyset = map.keySet();
        for (String key:keyset
             ) {
            // 通过键获取值
            String[] value = map.get(key);
            System.out.println(key+":"+value[0]);
        }*/

        // 方式三 values 获取所有值对象的Collection集合(只获取值,不获取键)
        Collection<String[]> values = map.values();
        for (String[] value:values
             ) {
            System.out.println(value[0]);
        }
    }
}
