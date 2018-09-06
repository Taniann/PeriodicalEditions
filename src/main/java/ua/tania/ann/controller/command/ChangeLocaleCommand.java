package ua.tania.ann.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 19.08.2018.
 */
public class ChangeLocaleCommand implements Command {
    private static final String LOCALE = "locale";
    private static final String REFERER = "Referer";


    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String locale = request.getParameter(LOCALE);
        request.getSession().setAttribute(LOCALE, locale);
        return new ResultPage(REDIRECT, request.getHeader(REFERER));
    }
}
