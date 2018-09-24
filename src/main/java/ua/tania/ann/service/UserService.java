package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.User;

/**
 * Created by Таня on 17.08.2018.
 */
public class UserService {
    private String EMAIL = "^[-\\w.]+\\@{1}([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";

    private static volatile UserService instance;

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

    /**
     * Insert new user
     * @param user
     */
    public boolean insert(User user) {
        if (loginIsExist(user.getLogin())) return false;
            return factory.createUserDAO().insert(user);
    }

    /**
     * Find user by login
     * @param login
     */
    public User findByLogin(String login) {
        return factory.createUserDAO().findByLogin(login);
    }

    /**
     * Find user by id
     * @param id
     */
    public User findById(int id) {
        return factory.createUserDAO().findById(id);
    }

    /**
     * Update user`s profile
     * @param user
     */
    public boolean updateProfile(User user) {
        return factory.createUserDAO().updateProfile(user);
    }

    /**
     * Update user`s profile with adding order data
     * @param user
     */
    public boolean updateProfileForOrder(User user) {
        return factory.createUserDAO().updateProfileForOrder(user);
    }

    /**
     * Update user`s password
     * @param user
     */
    public boolean updatePassword(User user) {
        return factory.createUserDAO().updatePassword(user);
    }

    /**
     * Check if user`s login is exist
     * @param login
     */
    public boolean loginIsExist(String login) {
        User user = factory.createUserDAO().findByLogin(login);
        if (user == null) return false;
        else return true;
    }

    /**
     * Check if user`s password correct
     * @param user
     * @param password
     */
    public boolean checkPassword(User user, String password){
        return password.equals(user.getPassword());
    }

    /**
     * Check if user`s phone correct
     * @param phone
     */
    public boolean isPhoneCorrect(String phone) {
        return phone.length() == 18;
    }

    /**
     * Check if user`s email correct
     * @param email
     */
    public boolean isEmailCorrect(String email) {
        return email.matches(EMAIL);
    }

    public void setFactory(DAOFactory factory) {
        this.factory = factory;
    }

}
