package ua.tania.ann.controller.command.admin;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 21.08.2018.
 */
public class DeleteEditionCommand implements Command{
    private static final String ID = "id";

    private EditionService editionService;

    public DeleteEditionCommand() {
        editionService = EditionService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT);

        int id = Integer.parseInt(request.getParameter(ID));

        if (editionService.delete(id)) {
            resultPage.setPage(JspPath.ADMIN_PAGE_COMMAND);
        }
        else {
            resultPage.setPage(JspPath.ERROR_PAGE);
        }

        return resultPage;
    }
}
