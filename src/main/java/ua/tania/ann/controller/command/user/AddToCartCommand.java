package ua.tania.ann.controller.command.user;

import ua.tania.ann.auxiliary.entity.CartRecord;
import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;
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

        ArrayList<CartRecord> cart = new ArrayList<>();

        Double amount = edition.getPrice() * countMonth(request);
        String[] months = monthValues(request);

        Double totalAmount = null;

        if (request.getSession(false).getAttribute("cart") != null) {
            ArrayList<CartRecord> existingCart = ( ArrayList<CartRecord>)request.getSession().getAttribute("cart");
            existingCart.add(new CartRecord(edition, amount, months));
            totalAmount = calculateTotalAmount(existingCart);
            request.getSession(false).setAttribute("cart", existingCart);

        } else {
            cart.add(new CartRecord(edition, amount, months));
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

    private String[] monthValues(HttpServletRequest request) {
        return request.getParameterValues("month");

    }
    private Double calculateTotalAmount(ArrayList<CartRecord> cart) {
        Double result = 0.0;
        for(CartRecord record : cart) {
            result += record.getAmount();
        }
        return result;
    }
}

