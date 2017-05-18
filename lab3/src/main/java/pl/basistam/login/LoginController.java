package pl.basistam.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private ActiveUsers users = ActiveUsers.getInstance();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("btnLogout") != null) {
            logout(request, response);
        } else if (request.getParameter("btnLogin") != null) {
            login(request, response);
        }
        response.sendRedirect(request.getContextPath() + "/login");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request,response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nick");
        String password = request.getParameter("password");
        int id = users.login(new User(name, password));
        if (id != -1) {
            request.getSession().setAttribute("user", name);
            request.getSession().setAttribute("id", id);
        } else {
            request.getSession().setAttribute("error", "Bledny login lub haslo");
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        users.logout((int) session.getAttribute("id"));
        session.setAttribute("user", null);
        session.invalidate();
    }
}
