package ua.tania.ann.controller.command.show;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 26.08.2018.
 */
public class ShowAddToCartPage implements Command {
    private static final String ID = "id";
    private EditionService editionService;

    public ShowAddToCartPage() {
        editionService = EditionService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT, JspPath.ADD_TO_CART_PAGE);

        Edition edition = editionService.findById(Integer.parseInt(request.getParameter(ID)));
        request.getSession(false).setAttribute("editionForCart", edition);

        return resultPage;
    }

}
