package pagination;

import libs.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 只有条件查询
        conditionQuery(req, resp);
    }

    private void conditionQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        DepartmentQuery query = WebUtil.copyRequestToBean(req,DepartmentQuery.class);

        // 获取条件查询数据
        DepartmentService departmentService = new DepartmentService();
        List<Department> list = departmentService.findByCondition(query);

        // 转发到jsp页面
        req.setAttribute("list",list);
        req.getRequestDispatcher("/pagination/departmentList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
