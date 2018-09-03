package ua.tania.ann.controller.command.user;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Category;
import ua.tania.ann.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Таня on 31.08.2018.
 */
public class SearchEditionByCategoryCommand implements Command {
    private static final String ID = "id";

    private CategoryService categoryService;

    public SearchEditionByCategoryCommand() { categoryService = CategoryService.getInstance();}
    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter(ID));

        List<Category> categoryList;
        return null;
    }
}
