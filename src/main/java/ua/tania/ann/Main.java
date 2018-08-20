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
        Locale.setDefault(Locale.US);
        ResourceBundle labels = ResourceBundle.getBundle("catalogPage", Locale.getDefault());
        System.out.println(labels.getString("catalogPage.signUp"));
    }
}
