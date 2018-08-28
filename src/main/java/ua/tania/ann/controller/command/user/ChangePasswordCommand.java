package ua.tania.ann.controller.command.user;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.UserService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;
import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 28.08.2018.
 */
public class ChangePasswordCommand implements Command {
    private static final String ID = "id";
    private static final String PASSWORD = "password";
    private static final String NEW_PASSWORD = "newPassword";

    private UserService userService;

    public ChangePasswordCommand() {
        userService = UserService.getInstance();
    }


    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage page = null;

        int id = Integer.parseInt(request.getParameter(ID));
        String password = request.getParameter(PASSWORD);
        String newPassword = request.getParameter(NEW_PASSWORD);

        User user = userService.findById(id);

        if (password.equals(user.getPassword()))  {
            user.setPassword(newPassword);
        }
        else {
            request.setAttribute("uncorrectOldPassword", true);
            return new ResultPage(FORWARD, JspPath.CHANGE_PASSWORD_PAGE);
        }

        if (userService.updatePassword(user)) {
            request.getSession(false).setAttribute("user", user);
            request.setAttribute("successfulMessage", true);
            page = new ResultPage(REDIRECT, JspPath.CHANGE_PASSWORD_PAGE);
        } else {
            request.setAttribute("errorMessage", true);
            page = new ResultPage(FORWARD, JspPath.PROFILE_PAGE);
        }
        return page;
    }

}
