package ua.tania.ann.controller.command.show;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;

/**
 * Created by Таня on 03.09.2018.
 */
public class ShowCatalogCommand implements Command {
    private static final int recordsPerPage = 6;

    private EditionService editionService;

    public ShowCatalogCommand() {editionService = EditionService.getInstance(); }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        request.getSession(false).setAttribute("editionList", editionService.findAll(currentPage, recordsPerPage));

        int rows = editionService.getNumberOfRows();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        return new ResultPage(FORWARD, JspPath.CATALOG_PAGE);
    }
}
