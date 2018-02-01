package web;

import base.entity.Contact;
import base.service.ContactService;
import base.service.InterfaceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取数据
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String id = req.getParameter("id");
        // 封装到类
        Contact contact = new Contact();
        contact.setName(name);
        contact.setGender(gender);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setAddress(address);
        contact.setId(id);

        InterfaceService service = new ContactService();
        service.updateContact(contact);
        // 跳转到列表页
        resp.sendRedirect(req.getContextPath()+"/contact/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
