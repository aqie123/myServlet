package pagination;

import libs.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pageQuery(req, resp);
        // 1 从用户参数中获取当前页数据
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        if(currentPage == null || currentPage.equals("")){
            // 第一次访问,未传递currentPage
            currentPage = "1";
        }
        if(pageSize == null || pageSize.equals("")){
            pageSize = "2";
        }
        int currentpage = Integer.parseInt(currentPage);
        int pagesize = Integer.parseInt(pageSize);

        // 2.封装PageBean对象
        PageBean pageBean = new PageBean(currentpage,pagesize);
        PageService service = new PageService();
        DepartmentService dpService = new DepartmentService();
        // 3.封装查询对象
        req.setCharacterEncoding("utf-8");
        EmployeeQuery query = WebUtil.copyRequestToBean(req,EmployeeQuery.class);

        // 4. 查询数据库,传入当页数据
        List<Employee> employees = service.queryEmployee(currentpage,pagesize,query);
        pageBean.setData(employees);
        pageBean.setTotalCount((int)service.countNumber()); // 总数量

        pageBean.setCurrentPage(currentpage);         // 当前页 (前一页,后一页,总页数)

        // 5.查询部门信息
        List<Department> departments =  dpService.findAll();

        // 6.PageBean对象放入域对象中
        req.setAttribute("pageBean",pageBean);
        req.setAttribute("departments",departments);

        // 7.转发jsp页面展示数据
        req.getRequestDispatcher("/pagination/empList.jsp").forward(req,resp);

    }

    // 分页查询
    private void pageQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 从用户参数中获取当前页数据
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        if(currentPage == null || currentPage.equals("")){
            // 第一次访问,未传递currentPage
            currentPage = "1";
        }
        if(pageSize == null || pageSize.equals("")){
            pageSize = "2";
        }
        int currentpage = Integer.parseInt(currentPage);
        int pagesize = Integer.parseInt(pageSize);

        // 2.封装PageBean对象
        PageBean pageBean = new PageBean(currentpage,pagesize);
        PageService service = new PageService();

        // 4. 查询数据库,传入当页数据
        List<Employee> employees = service.findCurrentPageInfo(currentpage,pagesize);
        pageBean.setData(employees);
        pageBean.setTotalCount((int)service.countNumber()); // 总数量

        pageBean.setCurrentPage(currentpage);         // 当前页 (前一页,后一页,总页数)

        // 5.PageBean对象放入域对象中
        req.setAttribute("pageBean",pageBean);
        // 6.转发jsp页面展示数据
        req.getRequestDispatcher("/pagination/empList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
