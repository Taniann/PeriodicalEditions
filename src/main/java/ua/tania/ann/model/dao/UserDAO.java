package ua.tania.ann.model.dao;

import ua.tania.ann.model.entity.User;

import java.util.List;

/**
 * Created by Таня on 17.08.2018.
 */
public interface UserDAO {
    boolean insert(User user);
    User findById(int id);
    List<User> findAll();
    boolean update(User user);
    boolean delete(int id);
}
