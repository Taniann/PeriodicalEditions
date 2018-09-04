package ua.tania.ann.model.dao;

import ua.tania.ann.model.entity.Edition;

import java.util.List;

/**
 * Created by Таня on 17.08.2018.
 */
public interface EditionDAO {
    boolean insert(Edition edition);
    Edition findById(int id);
    List<Edition> findAll();
    List<Edition> findAll(int currentPage, int recordsPerPage);
    List<Edition> findAllByCategoryId(int categoryId, int currentPage, int recordsPerPage);
    List<Edition> findAllByType(String type, int currentPage, int recordsPerPage);
    boolean update(Edition edition);
    boolean delete(int id);
    int getNumberOfRows();
}
