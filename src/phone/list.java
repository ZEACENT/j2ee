package phone;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.phoneform;
import dao.phoneformDAO;

public class list extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int start = 0;
        int count = 5;
        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
        }
        int total = new phoneformDAO().getTotal();
        int last;
        if (0 == total % count)
            last = total - count;
        else
            last = total - total % count;
        int next = start + count;
        next = next > last ? last : next;
        int pre = start - count;
        pre = pre < 0 ? 0 : pre;
        List<phoneform> phoneforms = new phoneformDAO().list(start, count);
        request.getSession().setAttribute("next", next);
        request.getSession().setAttribute("pre", pre);
        request.getSession().setAttribute("last", last);
        request.getSession().setAttribute("phoneforms", phoneforms);
        request.getRequestDispatcher("/phone/list.jsp").forward(request, response);
    }
}