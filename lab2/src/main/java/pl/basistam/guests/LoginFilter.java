package pl.basistam.guests;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/LoggingFilter")
public class LoginFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter");
        String login = request.getParameter("login");
        if (login != null && login.isEmpty()) {
            PrintWriter out = response.getWriter();
            request.getRequestDispatcher("/WEB-INF/Login.html").forward(request, response);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User or password incorrect');");
            out.println("</script>");
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
