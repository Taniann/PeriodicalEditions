package ua.tania.ann.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

/**
 * Created by Таня on 19.08.2018.
 */
public class SetEnglishCommand implements Command {
    static final Locale ENGLISH = Locale.US;

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Config.set(request.getSession(), Config.FMT_LOCALE, ENGLISH);
        return null;
    }
}
