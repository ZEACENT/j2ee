package phone;

import bean.order;
import dao.countDAO;
import dao.orderDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class count extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<order> orders = (List<order>) request.getSession().getAttribute("ordersform");
        int sum = (int) request.getSession().getAttribute("sum");
        String goods = null;
        for (order order : orders) {
            if (goods == null && order != null) {
                goods = order.getGoods();
            } else if (order != null) {
                goods += order.getGoods();
            }
        }
        if (goods != null) {
            new orderDAO().delete(request, 0);
            new countDAO().add(request, goods, sum);
        }
        response.sendRedirect("/j2ee_war_exploded/countlist");
    }
}