package phone;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.phoneform;
import dao.orderDAO;
import dao.phoneformDAO;

public class AddToCart extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getSession().getAttribute("userName") == null) {
                response.sendRedirect("/j2ee_war_exploded/phone/login.jsp");
                return;
            }
        }catch (NumberFormatException e){
            response.sendRedirect("/j2ee_war_exploded/phone/login.jsp");
            return;
        }
        String phone_version = request.getParameter("phone_version");
        phoneform phoneform = new phoneformDAO().get("phone_version", phone_version);
        new orderDAO().add(phoneform, request);
        response.sendRedirect("/j2ee_war_exploded/phone/list.jsp");
    }
}