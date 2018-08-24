package ua.tania.ann.controller;

import ua.tania.ann.controller.command.*;
import ua.tania.ann.controller.command.admin.AddEditionCommand;
import ua.tania.ann.controller.command.admin.ChangeEditionCommand;
import ua.tania.ann.controller.command.admin.DeleteEditionCommand;
import ua.tania.ann.controller.command.show.ShowAddEditionCommand;
import ua.tania.ann.controller.command.show.ShowAdminPageCommand;
import ua.tania.ann.controller.command.show.ShowChangeEditionCommand;

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
        commands.put("logout", new LogoutCommand());
        commands.put("setEnglish", new SetEnglishCommand());
        commands.put("setUkrainian", new SetUkrainianCommand());
        commands.put("addEdition", new AddEditionCommand());
        commands.put("deleteEdition", new DeleteEditionCommand());
        commands.put("showAddEdition", new ShowAddEditionCommand());
        commands.put("showAdminPage", new ShowAdminPageCommand());
        commands.put("changeEdition", new ChangeEditionCommand());
        commands.put("showChangeEdition", new ShowChangeEditionCommand());

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

