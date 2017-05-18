package pl.basistam.cars;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/car")
public class CarChoiceServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Cars.html").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String carType = request.getParameter("car_type");
        String minimum = request.getParameter("minimum_price");
        String maximum = request.getParameter("maximum_price");

        PrintWriter writer = response.getWriter();
        try {
            writer.println(
                    new CarChoiceHelper().findCars(
                            CarType.parse(carType),
                            Double.parseDouble(minimum),
                            Double.parseDouble(maximum)
                    ));
        } catch (NumberFormatException e) {
            writer.println("Wrong parameters!");
        }
        writer.flush();
        writer.close();
    }
}
