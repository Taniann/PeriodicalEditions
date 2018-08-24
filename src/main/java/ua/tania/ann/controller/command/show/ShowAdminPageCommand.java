package ua.tania.ann.controller.command.show;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;

/**
 * Created by Таня on 24.08.2018.
 */
public class ShowAdminPageCommand implements Command {
    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(FORWARD, JspPath.ADMIN_PAGE);
        request.getSession(false).setAttribute("editionList", EditionService.getInstance().findAll());


        return resultPage;
    }
}
