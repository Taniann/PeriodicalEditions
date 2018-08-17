package ua.tania.ann.utils;

import java.util.ResourceBundle;

/**
 * Created by Таня on 17.08.2018.
 */
public class MessageManager {
    private static MessageManager instance;

    private ResourceBundle resourceBundle;

    private static final String BUNDLE_NAME = "messages";
    public static final String SERVLET_EXCEPTION = "";
    public static final String IO_EXCEPTION= "";
    public static final String EXCEPTION= "";

    public static MessageManager getInstance() {
        if (instance == null) {
            instance = new MessageManager();
            instance.resourceBundle =
                    ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getMessage(String key) {
        return (String) resourceBundle.getObject(key);

    }
}
