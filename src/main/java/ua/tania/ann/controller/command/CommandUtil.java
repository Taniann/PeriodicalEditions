package ua.tania.ann.controller.command;

import ua.tania.ann.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Таня on 24.09.2018.
 */
public class CommandUtil {
    public static boolean isUserLogged(HttpServletRequest request, User user) {
        Set<User> loggedUsers = (HashSet<User>)request.getSession().getServletContext().getAttribute("loggedUsers");
        return loggedUsers.stream().anyMatch(user::equals);
    }

    public static void addLoggedUser(HttpServletRequest request, User user) {
        Set<User> loggedUsers = null;
        if (request.getSession().getServletContext().getAttribute("loggedUsers") != null) {
            loggedUsers = (HashSet<User>)request.getSession().getServletContext().getAttribute("loggedUsers");
            loggedUsers.add(user);
        } else {
            loggedUsers = new HashSet<>();
            loggedUsers.add(user);
        }
    }
}
