package ua.tania.ann.controller.command;

import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 17.08.2018.
 */
public class NoCommand implements Command {
    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ResultPage(REDIRECT, JspPath.LOGIN_PAGE);
    }
}
