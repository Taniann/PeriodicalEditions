package ua.tania.ann.controller.command.show;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.service.CategoryService;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;

/**
 * Created by Таня on 24.08.2018.
 */
public class ShowChangeEditionCommand implements Command {
    private static final String ID = "id";
    private static final String EDITION= "edition";

    private EditionService editionService;

    public ShowChangeEditionCommand() {
        editionService = EditionService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(FORWARD, JspPath.CHANGE_EDITION_PAGE);

        Edition edition = editionService.findById(Integer.parseInt(request.getParameter(ID)));
        request.getSession(false).setAttribute(EDITION, edition);

        return resultPage;
    }
}
