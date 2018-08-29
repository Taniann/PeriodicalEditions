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
 * Created by Таня on 29.08.2018.
 */
public class MakeOrderCommand implements Command {
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String MIDDLE_NAME = "middleName";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String CITY = "city";
    private static final String STREET_NAME = "streetName";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String INDEX = "index";
    private static final String FLAT_NUMBER = "flatNumber";

    private UserService userService;

    public MakeOrderCommand() {
        userService = UserService.getInstance();
    }

    @Override
    public ResultPage execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultPage page = null;

        int id = Integer.parseInt(request.getParameter(ID));
        String firstName = request.getParameter(FIRST_NAME);
        String secondName = request.getParameter(SECOND_NAME);
        String middleName = request.getParameter(MIDDLE_NAME);
        String email = request.getParameter(EMAIL);
        String phone = request.getParameter(PHONE);
        String city = request.getParameter(CITY);
        String streetName = request.getParameter(STREET_NAME);
        String houseNumber = request.getParameter(HOUSE_NUMBER);
        String index = request.getParameter(INDEX);
        String flatNumber = getValue(request, FLAT_NUMBER);

        User user = userService.findById(id);

        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMiddleName(middleName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCity(city);
        user.setStreetName(streetName);
        user.setHouseNumber(houseNumber);
        user.setIndex(index);
        user.setFlatNumber(flatNumber);

        if (userService.updateProfileForOrder(user)) {
            request.getSession(false).setAttribute("user", user);
            page = new ResultPage(REDIRECT, JspPath.PAYMENT_PAGE);
        } else {
            request.setAttribute("errorMessage", true);
            page = new ResultPage(FORWARD, JspPath.ORDER_PAGE);
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
