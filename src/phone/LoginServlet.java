package phone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import bean.user;
import dao.userDAO;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("POST".equals(request.getMethod())) {
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("pragma", "no-cache");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            user user = null;
            String pw = null;
            try {
                user = new userDAO().get(name);
                pw = user.getPassword();
            } catch (Exception e) {
                response.sendRedirect("/j2ee_war_exploded/phone/login.jsp");
                return;
            }
            if (pw.equals(password)) {
                request.getSession().setAttribute("userName", name);
                response.sendRedirect("/j2ee_war_exploded/phone/home.jsp");
            } else {
                response.sendRedirect("/j2ee_war_exploded/phone/login.jsp");
            }
        }
    }
}