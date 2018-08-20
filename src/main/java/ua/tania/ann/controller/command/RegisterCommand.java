package ua.tania.ann.controller.command;

import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Таня on 17.08.2018.
 */
public class RegisterCommand implements Command {
    private UserService userService;

    public RegisterCommand() {
         userService = UserService.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User newUser = new User(email, phone, login, password, false);
        if (userService.insert(newUser)) {
            return "catalog.jsp";
        }
        return "view/register.jsp";
    }
}
