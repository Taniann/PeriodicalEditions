package ua.tania.ann.controller.command;

import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 20.08.2018.
 */
public class LogoutCommand implements Command {
    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT, JspPath.WELCOME_PAGE);

        HttpSession session = request.getSession(false);
        session.invalidate();
        return resultPage;
    }
}
