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
public class EditProfileCommand implements Command {
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String MIDDLE_NAME = "middleName";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String CARD_BALANCE = "cardBalance";


    private UserService userService;

    public EditProfileCommand() {
        userService = UserService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage page = null;

        int id = Integer.parseInt(request.getParameter(ID));
        String firstName = getValue(request, FIRST_NAME);
        String secondName = getValue(request, SECOND_NAME);
        String middleName = getValue(request, MIDDLE_NAME);
        String email = getValue(request, EMAIL);
        String phone = getValue(request, PHONE);
        Double cardBalance = 0.0;
        try {
            cardBalance = Double.parseDouble(getValue(request, CARD_BALANCE));
        }catch (Exception e) {
            return new ResultPage(REDIRECT, JspPath.PROFILE_PAGE);
        }

        User user = userService.findById(id);

        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMiddleName(middleName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCardBalance(cardBalance);

        if (userService.updateProfile(user)) {
            request.getSession(false).setAttribute("user", user);
            page = new ResultPage(REDIRECT, JspPath.PROFILE_PAGE);
        } else {
            request.setAttribute("errorMessage", true);
            page = new ResultPage(FORWARD, JspPath.PROFILE_PAGE);
        }
        return page;
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
