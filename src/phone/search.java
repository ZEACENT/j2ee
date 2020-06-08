package phone;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.phoneform;
import dao.phoneformDAO;

public class search extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("key");
        String str = request.getParameter("str");
        List<phoneform> phoneforms = new phoneformDAO().search(key, str);
        int start = 0;
        int count = 5;
        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
        }
        int total = phoneforms.size();
        int last;
        if (0 == total % count)
            last = total - count;
        else
            last = total - total % count;
        int next = start + count;
        next = next > last ? last : next;
        int pre = start - count;
        pre = pre < 0 ? 0 : pre;
        request.getSession().setAttribute("next", next);
        request.getSession().setAttribute("pre", pre);
        request.getSession().setAttribute("last", last);
        request.getSession().setAttribute("phoneforms", phoneforms);
        request.getRequestDispatcher("/phone/list.jsp").forward(request, response);
    }
}