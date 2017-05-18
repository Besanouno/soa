package pl.basistam.guests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private final String LOGIN = "marcin";
    private final String PASSWORD = "admin1";

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");

        if (login == null || login.isEmpty()) {
            request.setAttribute("ErrorMessage", "Login is empty!");
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request,response);
            return;
        }
        if (password == null || password.isEmpty()) {
            request.setAttribute("ErrorMessage", "Password is empty!");
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request,response);
            return;
        }
        if (!LOGIN.equals(login) || !PASSWORD.equals(password)) {
            request.setAttribute("ErrorMessage", "Login or password is incorrect!");
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request,response);
            return;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", login);
        Cookie cookie = new Cookie("user", login);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", "/lab2/guests");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("user".equals(cookie.getName()) && LOGIN.equals(cookie.getValue())) {
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", "/lab2/guests");
                    return;
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/Login.html").forward(request, response);
    }
}
