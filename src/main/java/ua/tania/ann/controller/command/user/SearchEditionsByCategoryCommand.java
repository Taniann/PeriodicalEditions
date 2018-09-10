package ua.tania.ann.controller.command.user;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;

/**
 * Created by Таня on 31.08.2018.
 */
public class SearchEditionsByCategoryCommand implements Command {
    private static final String ID = "id";
    private static final int recordsPerPage = 4;

    private EditionService editionService;

    public SearchEditionsByCategoryCommand() {editionService = EditionService.getInstance(); }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter(ID));

        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        List<Edition> filteredEditionList = editionService.findAllByCategoryId(id, currentPage, recordsPerPage);
        request.getSession(false).setAttribute("editionList", filteredEditionList);

        int rows = filteredEditionList.size();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("id", id);
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        return new ResultPage(FORWARD, JspPath.CATALOG_PAGE_FILTERED_BY_CATEGORY);
    }
}
