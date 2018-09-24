package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.Category;

import java.util.List;

/**
 * Created by Таня on 26.08.2018.
 */
public class CategoryService {
    private static volatile CategoryService instance;

    private DAOFactory factory;

    private CategoryService(){
        factory = DAOFactory.getInstance();
    }

    public static CategoryService getInstance(){
        if(instance == null){
            synchronized (CategoryService.class){
                if (instance == null){
                    instance = new CategoryService();
                }
            }
        }
        return instance;
    }

    /**
     * Insert new edition`s category name
     */
    public boolean insert(Category category) {
        return factory.createCategoryDAO().insert(category);
    }

    /**
     * Insert categories which belongs to the edition
     * @param editionId
     * @param categories
     */
    public boolean insertEditionCategories(int editionId, List<Category> categories) {
        return factory.createCategoryDAO().insertEditionCategories(editionId, categories) == categories.size();
    }

    /**
     * Find all categories
     */
    public List<Category> findAll() {
        return factory.createCategoryDAO().findAll();
    }

    /**
     * Delete category
     */
    public boolean delete(int id) {
        return factory.createCategoryDAO().delete(id);
    }

}
