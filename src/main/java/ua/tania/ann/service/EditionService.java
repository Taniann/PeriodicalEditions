package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.Edition;

import java.util.List;

/**
 * Created by Таня on 17.08.2018.
 */
public class EditionService {
    private static EditionService instance;

    private DAOFactory factory;

    private EditionService(){
        factory = DAOFactory.getInstance();
    }

    public static EditionService getInstance(){
        if(instance == null){
            synchronized (EditionService.class){
                if (instance == null){
                    instance = new EditionService();
                }
            }
        }
        return instance;
    }

    public boolean insert(Edition edition) {
        return factory.createEditionDAO().insert(edition);
    }

    public List<Edition> findAll() {
        return factory.createEditionDAO().findAll();
    }

    public List<Edition> findAll(int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        return factory.createEditionDAO().findAll(start, recordsPerPage);
    }

    public List<Edition> findAllByCategoryId(int categoryId, int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        return factory.createEditionDAO().findAllByCategoryId(categoryId, start, recordsPerPage);
    }

    public List<Edition> findAllByType(String type, int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        return factory.createEditionDAO().findAllByType(type, start, recordsPerPage);
    }

    public boolean delete(int id) {
        return factory.createEditionDAO().delete(id);
    }

    public Edition findById(int id) {
        return factory.createEditionDAO().findById(id);
    }

    public boolean update(Edition edition) {
        return factory.createEditionDAO().update(edition);
    }

    public int getNumberOfRows() {
        return factory.createEditionDAO().getNumberOfRows();
    }
}
