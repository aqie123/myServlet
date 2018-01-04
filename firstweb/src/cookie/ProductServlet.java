package cookie;

import recent.Product;
import recent.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.读取所有商品信息
        ProductDao productDao = new ProductDao();
        List<Product> list = productDao.findAll();
        // 2.将商品显示到浏览器
        resp.setContentType("text/html;charset=utf-8");
        String html = "";
        // 3.
        html += "<html>";
        html += "<head><title>查看商品列表</title></head>";
        html += "<body>";
        html += "<table border='1' align='center' width='600px'>";
        html += "<tr><th>编号</th></tr><tr><th>名称</th></tr><tr><th>类型</th></tr><tr><th>价格</th></tr>";
        html += "</table>";
        html += "</body>";
        html += "</html>";


        resp.getWriter().write(html);
    }
}
