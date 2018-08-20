package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.validation.RegexConstant;

/**
 * Created by Таня on 17.08.2018.
 */
public class UserService {
    private static UserService instance;

    private DAOFactory factory;

    private UserService(){
        factory = DAOFactory.getInstance();
    }

    public static UserService getInstance(){
        if(instance == null){
            synchronized (UserService.class){
                if (instance == null){
                    instance = new UserService();
                }
            }
        }
        return instance;
    }


    public boolean insert(User user) {
        if (checkEmail(user.getEmail()) || checkPhoneNumber(user.getPhone())) {
            return factory.createUserDAO().insert(user);
        }
        else return false;
    }


    public boolean checkEmail(String email) {
        return email.matches(RegexConstant.EMAIL);
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(RegexConstant.TELEPHONE);
    }
}
