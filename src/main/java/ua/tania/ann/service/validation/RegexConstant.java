package ua.tania.ann.service.validation;

/**
 * Created by Таня on 20.08.2018.
 */
public interface RegexConstant {
    String NAME = "^[A-Z]{1}[a-z]+";
    String SURNAME = "^[A-Z]{1}[a-z]+";
    String TELEPHONE = "^\\+380\\d{9}";
    String EMAIL = "^[-\\w.]+\\@{1}([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
}
