package phone;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.count;
import dao.countDAO;

public class countlist extends HttpServlet {
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
        int start = 0;
        int count = 5;
        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
        }
        int total = new countDAO().getTotal(request);
        int last;
        if (0 == total % count)
            last = total - count;
        else
            last = total - total % count;
        int next = start + count;
        next = next > last ? last : next;
        int pre = start - count;
        pre = pre < 0 ? 0 : pre;
        List<count> counts = new countDAO().list(start, count, request);
        request.getSession().setAttribute("next", next);
        request.getSession().setAttribute("pre", pre);
        request.getSession().setAttribute("last", last);
        request.getSession().setAttribute("counts", counts);
        request.getRequestDispatcher("/phone/countlist.jsp").forward(request, response);
    }
}