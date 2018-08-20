package ua.tania.ann.controller.command;

import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.UserService;

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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String page = null;
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        User user = UserService.getInstance().findByLogin(login);

        if (user == null) {
            page = redirectToErrorPage(request);
        }
        else if (isCorrectPassword(user, password)) {
            page = pageChoice(user, request);
        }
        return page;
    }

    private boolean isCorrectPassword(User user, String inputPassword) {
        return UserService.getInstance().checkPassword(user, inputPassword);
    }

    private String pageChoice(User user, HttpServletRequest request) {
        String page = null;
        if (user.isAdmin()) {
            page = redirectToAdminPage(request, user);
        } else {
            page = redirectToUserPage(request, user);
        }
        return page;
    }

    private String redirectToAdminPage(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_ATTRIBUTE, user);

        return "/view/admin/adminPage.jsp";
    }

    private String redirectToUserPage(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_ATTRIBUTE, user);

        return "/view/user/catalog.jsp";
    }

    private String redirectToErrorPage(HttpServletRequest request) {
        request.setAttribute(ERROR_MESSAGE, true);
        return "/view/login.jsp";
    }
}
