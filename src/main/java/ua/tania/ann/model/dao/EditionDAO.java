package ua.tania.ann.model.dao;

import ua.tania.ann.model.entity.Edition;

import java.util.List;

/**
 * Created by Таня on 17.08.2018.
 */
public interface EditionDAO {
    void create(Edition edition);
    Edition findById(int id);
    List<Edition> findAll();
    void update(Edition edition);
    void delete(int id);
}