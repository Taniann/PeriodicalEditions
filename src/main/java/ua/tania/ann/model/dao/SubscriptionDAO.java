package ua.tania.ann.model.dao;

import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.model.entity.Subscription;

import java.util.List;

/**
 * Created by Таня on 30.08.2018.
 */
public interface SubscriptionDAO {
    boolean insert(Subscription subscription);
    List<Subscription> findAllByUserId(int id);
    List<Subscription> findAll();
    boolean delete(int id);
}
