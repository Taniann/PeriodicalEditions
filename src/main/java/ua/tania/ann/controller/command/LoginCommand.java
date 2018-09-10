package ua.tania.ann.controller.command;

import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.CategoryService;
import ua.tania.ann.service.UserService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 20.08.2018.
 */
public class LoginCommand implements Command {
    private static final String USER_ATTRIBUTE = "user";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String CATEGORIES = "categories";

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private UserService userService;

    public LoginCommand() {
        userService = UserService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(REDIRECT);

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        User user = userService.findByLogin(login);

        if (user == null) {
            resultPage = redirectToErrorPage(request, resultPage);
        }
        else if (isCorrectPassword(user, password)) {
            resultPage = pageChoice(user, request, resultPage);
        }
        else resultPage = redirectToErrorPage(request, resultPage);
        return resultPage;
    }

    public boolean isCorrectPassword(User user, String inputPassword) {
        return userService.checkPassword(user, inputPassword);
    }

    public ResultPage pageChoice(User user, HttpServletRequest request, ResultPage resultPage) {
        if (user.isAdmin()) {
            resultPage = redirectToAdminPage(request, user, resultPage);
        } else {
            resultPage = redirectToUserPage(request, user, resultPage);
        }
        return resultPage;
    }

    public ResultPage redirectToAdminPage(HttpServletRequest request, User user, ResultPage resultPage) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_ATTRIBUTE, user);

        resultPage.setPage(JspPath.ADMIN_PAGE_COMMAND);
        return resultPage;
    }

    public ResultPage redirectToUserPage(HttpServletRequest request, User user, ResultPage resultPage) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_ATTRIBUTE, user);
        session.setAttribute(CATEGORIES, CategoryService.getInstance().findAll());


        resultPage.setPage(JspPath.CATALOG_PAGE_COMMAND);
        return resultPage;
    }

    public ResultPage redirectToErrorPage(HttpServletRequest request, ResultPage resultPage) {
        request.setAttribute(ERROR_MESSAGE, true);
        resultPage.setPage(JspPath.LOGIN_PAGE);
        return resultPage;
    }
}
