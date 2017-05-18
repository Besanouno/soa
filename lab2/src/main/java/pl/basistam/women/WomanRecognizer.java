package pl.basistam.women;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/recognizer")
public class WomanRecognizer extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int age = Integer.parseInt(request.getParameter("age"));
        String name = request.getParameter("name");

        boolean isMatureWoman = age >= 18 && name.charAt(name.length()-1) == 'a';
        PrintWriter writer = response.getWriter();
        writer.println("Czy dane naleza do pelnoletniej kobiety? : " + (isMatureWoman ? "Tak" : "Nie"));
        writer.flush();
        writer.close();
    }
}
