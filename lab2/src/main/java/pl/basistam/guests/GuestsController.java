package pl.basistam.guests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/guests")
public class GuestsController extends HttpServlet {
    private List<Comment> comments = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("/WEB-INF/Guests.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("nick");
        String comment = request.getParameter("comment");
        comments.add(new Comment(nick, comment));

        request.setAttribute("comments", comments);
        request.getRequestDispatcher("/WEB-INF/Guests.jsp").forward(request, response);
    }
}
