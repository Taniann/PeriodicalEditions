package ua.tania.ann.model.dao.impl;

import ua.tania.ann.model.dao.*;

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

    @Override
    public CategoryDAO createCategoryDAO() {
        return CategoryDAOImpl.getInstance();
    }

    @Override
    public SubscriptionDAO createSubscriptionDAO() {
        return SubscriptionDAOImpl.getInstance();
    }
}
