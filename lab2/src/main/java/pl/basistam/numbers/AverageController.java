package pl.basistam.numbers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/average")
public class AverageController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(request.getParameter("n" + i));
        }
        PrintWriter writer = response.getWriter();
        writer.print("Średnia to: ");
        writer.println(new AverageCounter(numbers).count());
        writer.flush();
        writer.close();
    }
}
