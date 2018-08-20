package ua.tania.ann.controller.command;

import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.UserService;
import ua.tania.ann.utils.ConfigurationManager;

import javax.security.auth.login.Configuration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter(EMAIL);
        String phone = request.getParameter(PHONE);
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        User newUser = new User(email, phone, login, password, false);
        if (userService.insert(newUser)) {
            return ConfigurationManager.getInstance().getConfig(ConfigurationManager.LOGIN);
        }
        return ConfigurationManager.getInstance().getConfig(ConfigurationManager.REGISTER);
    }
}
