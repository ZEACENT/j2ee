package phone;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user;
import dao.userDAO;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String pass = request.getParameter("password");
        String repass = request.getParameter("repassword");
        String name = request.getParameter("loginname");
        if (pass.equals(repass)) {
            user ifExist = new userDAO().get(name);
            if (ifExist == null) {
                user user = new user();
                user.setLoginname(name);
                user.setPassword(pass);
                user.setPhone(request.getParameter("phone"));
                user.setAddress(request.getParameter("address"));
                user.setNickname(request.getParameter("nickname"));
                new userDAO().add(user);
                out.print("<script>alert('注册成功!');window.location.href='/j2ee_war_exploded/phone/login.jsp'</script>");
            } else {
                out.print("<script>alert('用户已存在');window.location.href='/j2ee_war_exploded/phone/register.jsp'</script>");
            }
        } else {
            out.print("<script>alert('密码前后不一致');window.location.href='/j2ee_war_exploded/phone/register.jsp'</script>");
        }
    }
}
