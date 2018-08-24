package ua.tania.ann.controller.command.admin;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.service.EditionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 21.08.2018.
 */
public class ChangeEditionCommand implements Command {
    private static final String NAME = "name";
    private static final String INFO = "info";
    private static final String PRICE = "price";
    private static final String IMAGE_URL = "image_url";
    private static final String TYPE = "type";

    private EditionService editionService;

    public ChangeEditionCommand() {
        editionService = EditionService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT);


        return null;
    }
}
