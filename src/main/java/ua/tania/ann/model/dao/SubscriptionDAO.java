package ua.tania.ann.model.dao;

import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.model.entity.Subscription;
import ua.tania.ann.model.entity.User;

import java.util.List;

/**
 * Created by Таня on 30.08.2018.
 */
public interface SubscriptionDAO {
    int insertWithPay(List<Subscription> subscriptions, User user);
    List<Subscription> findAllByUserId(int id);
}
