package ua.tania.ann.model.dao.impl;

import ua.tania.ann.model.dao.EditionDAO;
import ua.tania.ann.model.entity.Edition;

import java.util.List;

/**
 * Created by Таня on 17.08.2018.
 */
public class EditionDAOImpl implements EditionDAO {
    private static final EditionDAOImpl INSTANCE = new EditionDAOImpl();

    private EditionDAOImpl(){}

    static EditionDAOImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean insert(Edition edition) {
        return true;
    }

    @Override
    public Edition findById(int id) {
        return null;
    }

    @Override
    public List<Edition> findAll() {
        return null;
    }

    @Override
    public boolean update(Edition edition) {
        return true;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }
}
