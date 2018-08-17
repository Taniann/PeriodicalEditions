package ua.tania.ann.utils;

import java.util.ResourceBundle;

/**
 * Created by Таня on 17.08.2018.
 */
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private static ResourceBundle bundle;
    private static final String BUNDLE_NAME = "config";

    public static final String DRIVER_CLASS_NAME = "config.driverClassName";
    public static final String URL = "config.url";
    public static final String USERNAME = "config.username";
    public static final String PASSWORD = "config.password";
    public static final String DATABASE = "config.database";
    public static final String REGISTER = "config.register";

    public static final String LOGIN = "config.login";
    public static final String ERROR = "config.error";


    private ConfigurationManager(){
        bundle = ResourceBundle.getBundle(BUNDLE_NAME);
    }

    public static ConfigurationManager getInstance(){
        if(instance == null){
            synchronized (ConfigurationManager.class){
                if (instance == null){
                    instance = new ConfigurationManager();
                }
            }
        }

        return instance;
    }

    public String getConfig(String parameter){
        return bundle.getString(parameter);
    }
}
