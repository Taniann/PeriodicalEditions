package ua.tania.ann.controller.command.admin;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Category;
import ua.tania.ann.service.CategoryService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 26.08.2018.
 */
public class AddCategoryCommand implements Command {
    private static final String NAME = "name";

    private CategoryService categoryService;

    public AddCategoryCommand() {
        categoryService = CategoryService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT);

        String name = request.getParameter(NAME);

        Category newCategory = new Category(name);
        if (categoryService.insert(newCategory)) {
            resultPage.setPage(JspPath.CATEGORY_PAGE_COMMAND);
        }
        else {
            resultPage.setPage(JspPath.ERROR_PAGE);
        }
        return resultPage;
    }
}
