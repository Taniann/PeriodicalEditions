package ua.tania.ann.controller.command.user;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 26.08.2018.
 */
public class AddToCartCommand implements Command {
    private static final String ID = "id";

    private EditionService editionService;

    public AddToCartCommand()  {
        editionService = EditionService.getInstance();
    }
    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT);

        Edition edition = editionService.findById(Integer.parseInt(request.getParameter(ID)));

        List<Edition> cart = new ArrayList<>();

        int countMonth = countMonth(request);
        Double amount = edition.getPrice() * countMonth;
        List<Double> amounts = new ArrayList<>();


        if (request.getSession(false).getAttribute("cart") != null) {
            ((List<Edition>)request.getSession().getAttribute("cart")).add(edition);
        } else {
            cart.add(edition);
            request.getSession(false).setAttribute("cart", cart);
        }

        if (request.getSession(false).getAttribute("amounts") != null) {
            ((List<Double>)request.getSession().getAttribute("amounts")).add(amount);
        } else {
            amounts.add(amount);
            request.getSession(false).setAttribute("amounts", amounts);
        }

        resultPage.setPage(JspPath.CART_PAGE);

        return resultPage;
    }

    private int countMonth(HttpServletRequest request) {
        String[] month = request.getParameterValues("month");
        return month.length;
    }
}

