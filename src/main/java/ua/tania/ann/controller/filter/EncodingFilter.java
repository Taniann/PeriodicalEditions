package ua.tania.ann.controller.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Таня on 19.08.2018.
 */
public class EncodingFilter implements Filter {
    private final String ENCODING = "UTF-8";
    private final String CONTENT_TYPE = "text/html";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding(ENCODING);
        servletResponse.setContentType(CONTENT_TYPE);
        servletResponse.setCharacterEncoding(ENCODING);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
