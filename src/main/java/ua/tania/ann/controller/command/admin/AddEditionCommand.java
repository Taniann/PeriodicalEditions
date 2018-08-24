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
public class AddEditionCommand implements Command {
    private static final String NAME = "name";
    private static final String INFO = "info";
    private static final String PRICE = "price";
    private static final String IMAGE_URL = "image_url";
    private static final String TYPE = "type";

    private EditionService editionService;

    public AddEditionCommand() {
        editionService = EditionService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT);

        String name = request.getParameter(NAME);
        String info = request.getParameter(INFO);
        Double price = Double.parseDouble(request.getParameter(PRICE));
        String category = request.getParameter(IMAGE_URL);
        String type = request.getParameter(TYPE);

        Edition newEdition = new Edition(name, info, price, category, type);
        if (editionService.insert(newEdition)) {
            resultPage.setPage(JspPath.ADMIN_PAGE_COMMAND);
        }
        else {
            resultPage.setPage(JspPath.ERROR_PAGE);
        }
         return resultPage;
    }
}
