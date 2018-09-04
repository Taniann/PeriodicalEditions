package ua.tania.ann.model.dao;

import ua.tania.ann.model.entity.Category;
import ua.tania.ann.model.entity.Edition;

import java.util.List;

/**
 * Created by Таня on 26.08.2018.
 */
public interface CategoryDAO {
    boolean insert(Category category);
    boolean insertEditionCategories(int editionId, List<Category> categories);
    List<Category> findAll();
    boolean delete(int id);
    boolean deleteByEditionId(int editionId);

}
