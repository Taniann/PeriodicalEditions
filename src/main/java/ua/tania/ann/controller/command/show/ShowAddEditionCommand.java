package ua.tania.ann.controller.command.show;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;

/**
 * Created by Таня on 24.08.2018.
 */
public class ShowAddEditionCommand implements Command {
    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(FORWARD, JspPath.EDITION_ADD_PAGE);
        return resultPage;
    }
}
