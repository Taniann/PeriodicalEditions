package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.Edition;

import java.util.List;

/**
 * Created by Таня on 17.08.2018.
 */
public class EditionService {
    private static volatile EditionService instance;

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

    /**
     * Insert new edition
     */
    public boolean insert(Edition edition) {
        return factory.createEditionDAO().insert(edition);
    }

    /**
     * Find all editions
     */
    public List<Edition> findAll() {
        return factory.createEditionDAO().findAll();
    }

    /**
     * Find all editions with pagination
     * @param currentPage
     * @param recordsPerPage
     */
    public List<Edition> findAll(int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        return factory.createEditionDAO().findAll(start, recordsPerPage);
    }

    /**
     * Find all editions of required category with pagination
     * @param categoryId
     * @param currentPage
     * @param recordsPerPage
     */
    public List<Edition> findAllByCategoryId(int categoryId, int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        return factory.createEditionDAO().findAllByCategoryId(categoryId, start, recordsPerPage);
    }

    /**
     * Find all editions of required type with pagination
     * @param type
     * @param currentPage
     * @param recordsPerPage
     */
    public List<Edition> findAllByType(String type, int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        return factory.createEditionDAO().findAllByType(type, start, recordsPerPage);
    }

    /**
     * Delete edition
     */
    public boolean delete(int id) {
        return factory.createEditionDAO().delete(id);
    }


    /**
     * Find edition by id
     * @param id
     */
    public Edition findById(int id) {
        return factory.createEditionDAO().findById(id);
    }

    /**
     * update edition
     * @param edition
     */
    public boolean update(Edition edition) {
        return factory.createEditionDAO().update(edition);
    }

    /**
     * Get count of rows of edition table
     */
    public int getNumberOfRows() {
        return factory.createEditionDAO().getNumberOfRows();
    }
}
