import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Hero;

public class EL extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Hero hero =new Hero();
//        hero.setName("盖伦");
//        hero.setHp(616);
//        request.setAttribute("hero", hero);
        request.setAttribute("name", "gareen-servlet");
        request.getRequestDispatcher("EL.jsp").forward(request, response);
    }
}