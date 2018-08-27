package ua.tania.ann.controller.command.user;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;
import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 27.08.2018.
 */
public class DeleteFromCartCommand implements Command {
    private static final String ID = "id";


    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(FORWARD);

        int id = Integer.parseInt(request.getParameter(ID));
        Double amount = Double.parseDouble(request.getParameter("value"));

        Map<Edition, Double> existingCart = null;

        if (request.getSession(false).getAttribute("cart") != null) {
             existingCart = (Map<Edition, Double>)request.getSession(false).getAttribute("cart");
            removeFromCart(existingCart, id, amount);
        }

        Double newTotalAmount = calculateNewTotalAmount(existingCart);
        request.getSession(false).setAttribute("totalAmount", newTotalAmount);
        //request.getSession(false).setAttribute("cart", existingCart);
        resultPage.setPage(JspPath.CART_PAGE);

        return resultPage;
    }

    private void removeFromCart(Map<Edition, Double> cart, int id, Double amount) {
        Double removed = null;
        for(Map.Entry<Edition, Double> entry : cart.entrySet()) {
            if(entry.getKey().getId() == id && entry.getValue().equals(amount) && removed == null) {
                    removed = cart.remove(entry.getKey());
            }
        }
    }

    private Double calculateNewTotalAmount(Map<Edition, Double> cart) {
        Double result = 0.0;
        for(Map.Entry<Edition, Double> entry : cart.entrySet()) {
            result += entry.getValue();
        }
        return result;
    }
}
