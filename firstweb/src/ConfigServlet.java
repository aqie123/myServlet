import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigServlet extends HttpServlet {
    /*private ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = null;
        path = this.getServletConfig().getInitParameter("path");
        //path = config.getInitParameter("path");
        // 读取到servlet初始化参数(init-param)
        // 读取文件内容
        BufferedReader br = new BufferedReader(new FileReader(path));
        String str = null;
        while((str=br.readLine()) != null){
            System.out.println(str);
        }
    }
}
