package ua.tania.ann.controller.command.user;

import ua.tania.ann.auxiliary.entity.CartRecord;
import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;
import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 27.08.2018.
 */
public class DeleteFromCartCommand implements Command {
    private static final String ID = "id";



    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT);

        int id = Integer.parseInt(request.getParameter(ID));

        ArrayList<CartRecord> existingCart = null;

        if (request.getSession(false).getAttribute("cart") != null) {
             existingCart = (ArrayList<CartRecord>)request.getSession(false).getAttribute("cart");
            removeFromCart(existingCart, id);
            request.getSession(false).setAttribute("cart", existingCart);
        }

        Double newTotalAmount = calculateNewTotalAmount(existingCart);
        request.getSession(false).setAttribute("totalAmount", newTotalAmount);

        resultPage.setPage(JspPath.CART_PAGE);

        return resultPage;
    }


    private void removeFromCart(ArrayList<CartRecord> cart, int id) {
        for(CartRecord record : cart) {
            if(record.getId() == id) {
                   cart.remove(record);
            }
        }
    }

    private Double calculateNewTotalAmount(ArrayList<CartRecord> cart) {
        Double result = 0.0;
        for(CartRecord record : cart) {
            result += record.getAmount();
        }
        return result;
    }
}
