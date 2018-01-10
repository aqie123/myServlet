package web;

import MyException.NameExistException;
import entity.Contact;
import service.ContactService;
import service.InterfaceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 接收参数
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        // 封装到contact对象
        Contact contact = new Contact();
        contact.setName(name);
        contact.setGender(gender);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setAddress(address);
        // 调用service 层
        InterfaceService service = new ContactService();
        try{
            service.addContact(contact);
        } catch (NameExistException e) {
            req.setAttribute("msg",e.getMessage());
            req.getRequestDispatcher("/view/addContact.jsp").forward(req,resp);
            return;
        }
        resp.sendRedirect(req.getContextPath()+"/contact/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
