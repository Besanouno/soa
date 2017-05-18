package pl.basistam.beer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/WyborPiwa")
public class AgeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
            int age = Integer.parseInt(request.getParameter("age"));
            if (age < 18) {
                blockForUnderage(response);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void blockForUnderage(ServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Hola hola jestes niepelnoletni");
        writer.close();
    }

    @Override
    public void destroy() {

    }
}
