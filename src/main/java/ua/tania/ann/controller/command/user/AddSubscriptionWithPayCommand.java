package ua.tania.ann.controller.command.user;

import ua.tania.ann.auxiliary.entity.CartRecord;
import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Subscription;
import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.PaymentService;
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
public class AddSubscriptionWithPayCommand implements Command {
    private static final String CARD_NUMBER = "cardNumber";
    private static final String CVV = "cvv";
    private static final String CART = "cart";
    private static final String USER = "user";
    private static final String ERROR_INPUT_DATA = "errorInputData";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String TOTAL_AMOUNT = "totalAmount";



    private SubscriptionService subscriptionService;
    private PaymentService paymentService;

    public AddSubscriptionWithPayCommand()  {
        subscriptionService = SubscriptionService.getInstance();
        paymentService = PaymentService.getInstance();
    }


    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cardNumber = getValue(request, CARD_NUMBER);
        String cvv = getValue(request, CVV);


        if (!subscriptionService.isCardNumberCorrect(cardNumber) || !subscriptionService.isCvvCorrect(cvv)
                || request.getSession(false).getAttribute(CART) == null) {
            request.setAttribute(ERROR_INPUT_DATA, true);
            return new ResultPage(FORWARD, JspPath.PAYMENT_PAGE);
        }

        User user =  (User)request.getSession().getAttribute(USER);
        Double totalAmount = (Double) request.getSession().getAttribute(TOTAL_AMOUNT);

        if (paymentService.isBalanceNotEnough(user, totalAmount)) {
            request.setAttribute(ERROR_MESSAGE, true);
            return new ResultPage(FORWARD, JspPath.PAYMENT_PAGE);
        }else {
            user.setCardBalance(paymentService.getNewBalanceForInsert(user, totalAmount));
        }

        ArrayList<CartRecord> cart = (ArrayList<CartRecord>) request.getSession().getAttribute(CART);
        ArrayList<Subscription> subscriptionsForInsert = new ArrayList<>();

        for (CartRecord cartRecord : cart) {
            Subscription subscription = new Subscription(user.getId(), cartRecord.getEdition().getId(),
                                            cartRecord.getMonths(), cartRecord.getAmount() );
            subscriptionsForInsert.add(subscription);
        }

        if (subscriptionService.insertWithPay(subscriptionsForInsert, user)) {
            request.getSession().setAttribute(CART, null);
            return new ResultPage(REDIRECT, JspPath.CATALOG_PAGE_COMMAND);
        } else {
            request.setAttribute(ERROR_MESSAGE, true);
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
