package pl.basistam.soa.main.security.filters;

import pl.basistam.soa.main.security.CurrentSession;
import pl.basistam.soa.main.security.LoggedUsers;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    @Inject
    private LoggedUsers loggedUsers;

    @Inject
    private CurrentSession currentSession;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String remoteUser = httpRequest.getRemoteUser();

        if (remoteUser != null && httpRequest.getSession().getAttribute("user") == null) {
            if (loggedUsers.isLogged(remoteUser)) {
                httpRequest.getSession().invalidate();
                ((HttpServletResponse) servletResponse).sendRedirect("/mainApp/multipleLogin.xhtml?faces-redirect=true");
            } else {
                currentSession.setUser(remoteUser);
                httpRequest.getSession().setAttribute("user", true);
                loggedUsers.login(remoteUser);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
