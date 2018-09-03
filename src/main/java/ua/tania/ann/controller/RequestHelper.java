package ua.tania.ann.controller;

import ua.tania.ann.controller.command.*;
import ua.tania.ann.controller.command.admin.*;
import ua.tania.ann.controller.command.show.*;
import ua.tania.ann.controller.command.user.*;

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
        commands.put("addCategory", new AddCategoryCommand());
        commands.put("showAddCategory", new ShowAddCategoryCommand());
        commands.put("deleteCategory", new DeleteCategoryCommand());
        commands.put("addToCartPage", new ShowAddToCartPage());
        commands.put("addToCart", new AddToCartCommand());
        commands.put("deleteFromCart", new DeleteFromCartCommand());
        commands.put("editProfile", new EditProfileCommand());
        commands.put("changePassword", new ChangePasswordCommand());
        commands.put("makeOrder", new MakeOrderCommand());
        commands.put("addSubscription", new AddSubscriptionCommand());
        commands.put("reviewSubscriptions", new ReviewSubscriptionsCommand());
        commands.put("searchEditionByCategory", new SearchEditionByCategoryCommand());
        commands.put("showCatalogPage", new ShowCatalogCommand());
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

