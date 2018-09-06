package ua.tania.ann.controller.command.show;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.service.CategoryService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;

/**
 * Created by Таня on 26.08.2018.
 */
public class ShowAddCategoryCommand implements Command {
    private static final String CATEGORY_LIST = "categoryList";

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(FORWARD, JspPath.CATEGORY_ADD_PAGE);
        request.getSession(false).setAttribute(CATEGORY_LIST, CategoryService.getInstance().findAll());

        return resultPage;
    }
}
