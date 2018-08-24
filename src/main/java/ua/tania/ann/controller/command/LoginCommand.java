package ua.tania.ann.controller.command;

import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.EditionService;
import ua.tania.ann.service.UserService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.tania.ann.controller.command.CommandUtil.ERROR_MESSAGE;
import static ua.tania.ann.controller.command.CommandUtil.USER_ATTRIBUTE;

/**
 * Created by Таня on 20.08.2018.
 */
public class LoginCommand implements Command {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(ResultPage.RoutingType.REDIRECT);

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        User user = UserService.getInstance().findByLogin(login);

        if (user == null) {
            resultPage = redirectToErrorPage(request, resultPage);
        }
        else if (isCorrectPassword(user, password)) {
            resultPage = pageChoice(user, request, resultPage);
        }
        return resultPage;
    }

    private boolean isCorrectPassword(User user, String inputPassword) {
        return UserService.getInstance().checkPassword(user, inputPassword);
    }

    private ResultPage pageChoice(User user, HttpServletRequest request, ResultPage resultPage) {
        if (user.isAdmin()) {
            resultPage = redirectToAdminPage(request, user, resultPage);
        } else {
            resultPage = redirectToUserPage(request, user, resultPage);
        }
        return resultPage;
    }

    private ResultPage redirectToAdminPage(HttpServletRequest request, User user, ResultPage resultPage) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_ATTRIBUTE, user);

        resultPage.setPage(JspPath.ADMIN_PAGE_COMMAND);
        return resultPage;
    }

    private ResultPage redirectToUserPage(HttpServletRequest request, User user, ResultPage resultPage) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_ATTRIBUTE, user);
        session.setAttribute("editionList", EditionService.getInstance().findAll());


        resultPage.setPage(JspPath.CATALOG_PAGE);
        return resultPage;
    }

    private ResultPage redirectToErrorPage(HttpServletRequest request, ResultPage resultPage) {
        request.setAttribute(ERROR_MESSAGE, true);
        resultPage.setPage(JspPath.LOGIN_PAGE);
        return resultPage;
    }
}
