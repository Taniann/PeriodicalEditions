package ua.tania.ann.controller.command.admin;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Category;
import ua.tania.ann.service.CategoryService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;
import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 05.09.2018.
 */
public class AddEditionCategoriesCommand implements Command {
    private static final String ID = "id";
    private static final String NOT_CHECKED = "notCkecked";
    private static final String CHECKED_CATEGORY = "chekedCategory";



    private CategoryService categoryService;

    public AddEditionCategoriesCommand() {
        categoryService = CategoryService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT);

        int id = Integer.parseInt(request.getParameter(ID));
        List<Category> editionCategories = null;

       try {
           editionCategories = addEditionCategories(request);

       } catch (NullPointerException ex) {
           request.setAttribute(NOT_CHECKED, true);
           return new ResultPage(FORWARD, JspPath.ADD_EDITION_CATEGORIES_PAGE);
       }

        if (categoryService.insertEditionCategories(id, editionCategories)) {
            resultPage.setPage(JspPath.ADMIN_PAGE_COMMAND);
        }
        else {
            resultPage.setPage(JspPath.ERROR_PAGE);
        }

        return resultPage;

    }

    private List<Category> addEditionCategories(HttpServletRequest request) {
        List<Category> result = new ArrayList<>();


        String[] chekedCategories = request.getParameterValues(CHECKED_CATEGORY);

        for (String str: chekedCategories)
        {
            int id = Integer.parseInt(str);
            Category category = new Category(id);
            result.add(category);
        }

        return result;
    }
}
