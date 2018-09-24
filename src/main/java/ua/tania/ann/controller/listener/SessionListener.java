package ua.tania.ann.controller.listener;

import ua.tania.ann.model.entity.User;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Таня on 24.09.2018.
 */
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        Set<User> loggedUsers = (HashSet<User>) httpSessionEvent
                .getSession().getServletContext()
                .getAttribute("loggedUsers");
        User user = (User) httpSessionEvent.getSession()
                .getAttribute("user");
        loggedUsers.remove(user);
        httpSessionEvent.getSession().setAttribute(
                "loggedUsers", loggedUsers);
        httpSessionEvent.getSession().setAttribute("user", null);
    }
}
