package ua.tania.ann.controller.command.user;

import ua.tania.ann.auxiliary.entity.CartRecord;
import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Subscription;
import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.SubscriptionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;
import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 30.08.2018.
 */
public class AddSubscriptionCommand implements Command {
    private static final String CARD_NUMBER = "cardNumber";
    private static final String CVV = "cvv";

    private SubscriptionService subscriptionService;

    public AddSubscriptionCommand()  {
        subscriptionService = SubscriptionService.getInstance();
    }



    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cardNumber = getValue(request, CARD_NUMBER);
        String cvv = getValue(request, CVV);

        if (!subscriptionService.isCardNumberCorrect(cardNumber) || !subscriptionService.isCvvCorrect(cvv)
                || request.getSession(false).getAttribute("cart") == null) {
            request.setAttribute("errorMessage", true);
            return new ResultPage(FORWARD, JspPath.PAYMENT_PAGE);
        }

        Subscription subscription = null;
        boolean isInserted = false;
        User user =  (User)request.getSession().getAttribute("user");

        ArrayList<CartRecord> cart = (ArrayList<CartRecord>) request.getSession().getAttribute("cart");

        for (CartRecord cartRecord : cart) {
            subscription = new Subscription(user.getId(), cartRecord.getEdition().getId(),
                                            cartRecord.getMonths(), cartRecord.getAmount() );
            isInserted = subscriptionService.insert(subscription);
        }
        
        request.getSession().setAttribute("cart", null);

        if (isInserted) {
            return new ResultPage(REDIRECT, JspPath.CATALOG_PAGE);
        } else {
            request.setAttribute("errorMessage", true);
            return new ResultPage(FORWARD, JspPath.PAYMENT_PAGE);
        }
    }


    private String getValue(HttpServletRequest request, String parametrName) {
        String result ="";
        try {
            result = request.getParameter(parametrName);
        }catch (NullPointerException e) {
            return result;
        }
        return result;
    }
}
