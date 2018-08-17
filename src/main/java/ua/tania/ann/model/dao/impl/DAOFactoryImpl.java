package ua.tania.ann.model.dao.impl;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.dao.EditionDAO;
import ua.tania.ann.model.dao.UserDAO;

/**
 * Created by Таня on 17.08.2018.
 */
public class DAOFactoryImpl extends DAOFactory {

    @Override
    public UserDAO createUserDAO() {
        return UserDAOImpl.getInstance();
    }

    @Override
    public EditionDAO createEditionDAO() {
        return EditionDAOImpl.getInstance();
    }
}
