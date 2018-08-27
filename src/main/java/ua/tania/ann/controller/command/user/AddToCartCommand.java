package ua.tania.ann.controller.command.user;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<Edition, Double> cart = new HashMap<>();

        Double amount = edition.getPrice() * countMonth(request);

        Double totalAmount = null;

        if (request.getSession(false).getAttribute("cart") != null) {
            Map<Edition, Double> existingCart = ( Map<Edition, Double>)request.getSession().getAttribute("cart");
            existingCart.put(edition, amount);
            totalAmount = calculateTotalAmount(existingCart);
        } else {
            cart.put(edition, amount);
            totalAmount = amount;
            request.getSession(false).setAttribute("cart", cart);
        }


        request.getSession(false).setAttribute("totalAmount", totalAmount);
        resultPage.setPage(JspPath.CART_PAGE);

        return resultPage;
    }

    private int countMonth(HttpServletRequest request) {
        String[] month = request.getParameterValues("month");
        return month.length;
    }

    private Double calculateTotalAmount(Map<Edition, Double> cart) {
        Double result = 0.0;
        for(Map.Entry<Edition, Double> entry : cart.entrySet()) {
            result += entry.getValue();
        }
        return result;
    }
}

