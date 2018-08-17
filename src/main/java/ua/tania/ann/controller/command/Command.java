package ua.tania.ann.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Таня on 17.08.2018.
 */
public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
