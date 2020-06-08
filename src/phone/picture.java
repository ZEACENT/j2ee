package phone;

import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class picture extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pic = request.getParameter("pic");
    String html = "<img width='400' height='300' src='/j2ee_war_exploded/phoneSource/"
                    + pic + "' />";
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.format(html, pic);
    }
}