package ua.tania.ann;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Таня on 16.08.2018.
 */
public class Main {
    private static final String LANGUAGE_UK = "uk";
    private static final String COUNTRY_UA = "UA";
    static final Locale UKRAINIAN = new Locale(LANGUAGE_UK, COUNTRY_UA);

    public static void main(String[] args) {
        ResourceBundle labels = ResourceBundle.getBundle("registrationPage", UKRAINIAN);
        System.out.println(labels.getString("registrationPage.email"));
    }
}
