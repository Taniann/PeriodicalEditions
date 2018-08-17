package ua.tania.ann.model.dao.impl;

import ua.tania.ann.model.dao.UserDAO;
import ua.tania.ann.model.entity.User;

import java.util.List;

/**
 * Created by Таня on 17.08.2018.
 */
public class UserDAOImpl implements UserDAO {
    private static final UserDAOImpl INSTANCE = new UserDAOImpl();

    private static final String TABLE_NAME = "user";

    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String IS_ADMIN = "is_admin";
    private static final String FIRST_NAME = "first_name";
    private static final String SECOND_NAME = "second_name";
    private static final String MIDDLE_NAME = "middle_name";

    private UserDAOImpl(){}

    static UserDAOImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
