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
 * Created by Таня on 04.09.2018.
 */
public class SearchEditionsByTypeCommand implements Command {
    private static final String TYPE = "type";
    private static final int recordsPerPage = 6;

    private EditionService editionService;

    public SearchEditionsByTypeCommand() {editionService = EditionService.getInstance(); }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type = request.getParameter(TYPE);

        int currentPage = Integer.valueOf(request.getParameter("currentPage"));

        List<Edition> filteredEditionList = editionService.findAllByType(type, currentPage, recordsPerPage);
        request.getSession(false).setAttribute("editionList", filteredEditionList);

        int rows = filteredEditionList.size();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("type", type);
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        return new ResultPage(FORWARD, JspPath.CATALOG_PAGE_FILTERED_BY_TYPE);
    }
}
