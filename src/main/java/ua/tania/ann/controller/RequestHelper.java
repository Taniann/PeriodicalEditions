package ua.tania.ann.controller;

import ua.tania.ann.controller.command.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Таня on 17.08.2018.
 */
public class RequestHelper {
    private static RequestHelper instance = null;

    Map<String, Command> commands = new HashMap<>();

    private RequestHelper() {
        commands.put("register", new RegisterCommand());
        commands.put("login", new LoginCommand());
        commands.put("setEnglish", new SetEnglishCommand());
        commands.put("setUkrainian", new SetUkrainianCommand());

    }

    public Command getCommand(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        Command command = commands.get(commandName);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }
}

