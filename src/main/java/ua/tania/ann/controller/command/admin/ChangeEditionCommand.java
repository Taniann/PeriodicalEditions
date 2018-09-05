package ua.tania.ann.controller.command.admin;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Category;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.service.CategoryService;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 21.08.2018.
 */
public class ChangeEditionCommand implements Command {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String INFO = "info";
    private static final String PRICE = "price";
    private static final String IMAGE_URL = "imageUrl";
    private static final String TYPE = "type";

    private EditionService editionService;

    public ChangeEditionCommand() {
        editionService = EditionService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT);

        int id = Integer.parseInt(request.getParameter(ID));
        String name = request.getParameter(NAME);
        String info = request.getParameter(INFO);
        Double price = Double.parseDouble(request.getParameter(PRICE));
        String imageUrl = request.getParameter(IMAGE_URL);
        String type = request.getParameter(TYPE);

        Edition edition = new Edition(id, name, info, price, imageUrl, type);
        if (editionService.update(edition)) {
            resultPage.setPage(JspPath.ADMIN_PAGE_COMMAND);
        }
        else {
            resultPage.setPage(JspPath.ERROR_PAGE);
        }
        return resultPage;
    }

}