package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

public class HeroUpdateServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        Hero hero = new Hero();
        hero.setId(Integer.parseInt(request.getParameter("id")));
        hero.setName(request.getParameter("name"));
        hero.setHp(Float.parseFloat(request.getParameter("hp")));
        hero.setDamage(Integer.parseInt(request.getParameter("damage")));
        new HeroDAO().update(hero);
//        response.sendRedirect("listHero");
        request.getRequestDispatcher("listHero").forward(request, response);
    }
}