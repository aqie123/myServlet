import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// servlet多线程并发问题
public class ThreadServlet extends HttpServlet {
    // 成员变量，该数据可能被不同用户线程共享到
    static int count = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        /*synchronized (ThreadServlet.class){
            resp.getWriter().write("您是第"+count+"名访客");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }*/
        method(resp);
    }

    public synchronized static void method(HttpServletResponse resp) throws IOException {
        resp.getWriter().write("您是第"+count+"名访客");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
}
