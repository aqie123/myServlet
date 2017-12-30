import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeServlet extends HttpServlet {
    // 构造方法
    public LifeServlet(){
        System.out.println("创建servlet对象");
    }

    // 初始化方法
    @Override
    public void init() throws ServletException {
        System.out.println("init 方法被调用");
    }

    // 服务方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service 方法被调用");
    }

    @Override
    public void destroy() {
        System.out.println("servlet 被销毁");
    }
}
