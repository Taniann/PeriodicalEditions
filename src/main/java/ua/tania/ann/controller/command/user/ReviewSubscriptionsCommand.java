package ua.tania.ann.controller.command.user;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.model.entity.Subscription;
import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.service.SubscriptionService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 30.08.2018.
 */
public class ReviewSubscriptionsCommand implements Command {
    private SubscriptionService subscriptionService;
    private EditionService editionService;


    public ReviewSubscriptionsCommand() {
        editionService = EditionService.getInstance();
        subscriptionService = SubscriptionService.getInstance();
    }
    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User)request.getSession(false).getAttribute("user");

        List<Subscription> subscriptions = subscriptionService.findAllByUserId(user.getId());
        List<Edition> editions = editionService.findAll();

        request.getSession(false).setAttribute("subscriptions", subscriptions);
        request.getSession(false).setAttribute("editions", editions);


        return new ResultPage(REDIRECT, JspPath.SUBSCRIPTIONS_PAGE);
    }
}
