package ua.tania.ann.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

/**
 * Created by Таня on 19.08.2018.
 */
public class SetUkrainianCommand implements Command {
    private static final String LANGUAGE_UK = "uk";
    private static final String COUNTRY_UA = "UA";
    static final Locale UKRAINIAN = new Locale(LANGUAGE_UK, COUNTRY_UA);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(null, null);
        Config.set(request.getSession(), Config.FMT_LOCALE, UKRAINIAN);
        return request.getServletPath();
    }
}
