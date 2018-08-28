package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.User;

/**
 * Created by Таня on 17.08.2018.
 */
public class UserService {
    private String EMAIL = "^[-\\w.]+\\@{1}([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";

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
        if (loginIsExist(user.getLogin())) return false;
            return factory.createUserDAO().insert(user);
    }

    public User findByLogin(String login) {
        return factory.createUserDAO().findByLogin(login);
    }

    public User findById(int id) {
        return factory.createUserDAO().findById(id);
    }

    public boolean updateProfile(User user) {
        return factory.createUserDAO().updateProfile(user);
    }

    public boolean updatePassword(User user) {
        return factory.createUserDAO().updatePassword(user);
    }


    public boolean loginIsExist(String login) {
        User user = factory.createUserDAO().findByLogin(login);
        if (user == null) return false;
        else return true;
    }

    public boolean checkPassword(User user, String password){
        return password.equals(user.getPassword());
    }

    public boolean isPhoneCorrect(String phone) {
        return phone.length() == 18;
    }

    public boolean isEmailCorrect(String email) {
        return email.matches(EMAIL);
    }
}
