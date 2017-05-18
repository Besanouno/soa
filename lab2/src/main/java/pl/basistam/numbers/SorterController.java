package pl.basistam.numbers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/sort")
public class SorterController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Double> numbers;
        try {
            numbers = collectParameters(request);
        } catch(NumberFormatException e) {
            sendWrongParameterMessage(response);
            return;
        }
        PrintWriter writer = response.getWriter();
        Collections.sort(numbers);
        writer.println(numbers);
    }

    private List<Double> collectParameters(HttpServletRequest request) throws NumberFormatException {
        Enumeration<String> parameterNames = request.getParameterNames();
        List<Double> numbers = new ArrayList<>();
        Collections.list(parameterNames)
                .stream()
                .map(request::getParameter)
                .mapToDouble(Double::parseDouble)
                .forEach(numbers::add);
        return numbers;
    }

    private void sendWrongParameterMessage(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Wrong parameters!");
        writer.flush();
        writer.close();
    }
}
