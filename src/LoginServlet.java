import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        System.out.println("LoginServlet是单实例的 构造方法 被调用");
    }

    public void init(ServletConfig config) {
        System.out.println("init(ServletConfig)");
    }

    public void destroy() {
        System.out.println("destroy()");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
        System.out.println("请求行中的参数部分: " + request.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
        System.out.println("服务器的IP地址: " + request.getLocalAddr());
        System.out.println("服务器的主机名: " + request.getLocalName());
        System.out.println("得到客户机请求方式: " + request.getMethod());

        if ("POST".equals(request.getMethod())) {
            String strFormat = "Method %s is used.";
            strFormat = String.format(strFormat, request.getMethod());
            System.out.println(strFormat);
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("pragma", "no-cache");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            System.out.println("name:" + name);
            System.out.println("password:" + password);
            String html = null;
            if ("hzs".equals(name) && "pw".equals(password)) {
                request.getSession().setAttribute("userName", name);
                response.sendRedirect("listHero");
//                request.getRequestDispatcher("success.html").forward(request, response);
////                html = "<div style='color:red'>Success!</div>" +
////                        "<div style='color:red'>Welcome!</div>" +
////                        "<div style='color:black'>黄志生同学</div>";
            } else {
                response.sendRedirect("login.jsp");
//                response.setStatus(301) ;
//                response.setHeader("Location", "fail.html");
//                response.sendRedirect("fail.html");
//                html = "<div style='color:red'>Fail</div>";
            }
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter pw = response.getWriter();
//            String header = "<html><head><meta charset=\"UTF-8\"></head><body>";
//            String footer = "</body></html>";
//            html = header + html + footer;
//            pw.println(html);
        }
    }
}