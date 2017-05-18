package pl.basistam.beer;

import pl.basistam.beer.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/WyborPiwa", name = "Servlet_wybierzpiwo")
public class BeerChoice extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String color = request.getParameter("color");
        BeerExpert ekspert = new BeerExpert();
        request.setAttribute("brands", ekspert.getBrands(color));
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/wynik.jsp");
        view.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/form.html").forward(request,response);
    }
}
