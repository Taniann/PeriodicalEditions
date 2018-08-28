package ua.tania.ann.controller.command;

import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.UserService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;
import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 17.08.2018.
 */
public class RegisterCommand implements Command {
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";


    private UserService userService;

    public RegisterCommand() {
         userService = UserService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage resultPage = new ResultPage(FORWARD);

        String email = request.getParameter(EMAIL);
        String phone = request.getParameter(PHONE);
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        if (!userService.isEmailCorrect(email)) {
            request.setAttribute("uncorrectEmail", true);
            resultPage.setPage(JspPath.REGISTER_PAGE);
            return resultPage;
        }

        if (!userService.isPhoneCorrect(phone)) {
            request.setAttribute("uncorrectPhone", true);
            resultPage.setPage(JspPath.REGISTER_PAGE);
            return resultPage;
        }

        User newUser = new User(email, phone, login, password, false);
        if (userService.insert(newUser)) {
            resultPage = new ResultPage(REDIRECT,JspPath.LOGIN_PAGE );
        }
        else {
            request.setAttribute("errorMessage", true);
            resultPage.setPage(JspPath.REGISTER_PAGE);
        }

        return resultPage;
    }
}
