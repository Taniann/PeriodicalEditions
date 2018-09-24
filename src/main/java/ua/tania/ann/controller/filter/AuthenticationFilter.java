package ua.tania.ann.controller.filter;

import ua.tania.ann.model.entity.User;
import ua.tania.ann.utils.JspPath;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Таня on 24.09.2018.
 */
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =
                (HttpServletRequest) servletRequest;
        HttpServletResponse response =
                (HttpServletResponse) servletResponse;
        User user = null;
        try {
            user = (User)request.getSession(false).getAttribute("user");
        } catch (NullPointerException ex) {

        }
        String requestURI = request.getRequestURI();
        if ((requestURI.contains(JspPath.CATALOG_PAGE) || requestURI.contains(JspPath.ADMIN_PAGE))
                && user == null) {
            response.sendRedirect(JspPath.LOGIN_PAGE);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
