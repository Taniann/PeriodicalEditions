package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.Subscription;

import java.util.List;

/**
 * Created by Таня on 30.08.2018.
 */
public class SubscriptionService {
    private static SubscriptionService instance;

    private DAOFactory daoFactory;

    private SubscriptionService() {daoFactory = DAOFactory.getInstance();}

    public static SubscriptionService getInstance() {
        if(instance == null){
        synchronized (SubscriptionService.class){
            if (instance == null){
                instance = new SubscriptionService();
            }
        }
    }
        return instance;
    }

    public boolean insert(Subscription subscription) {
        return daoFactory.createSubscriptionDAO().insert(subscription);
    }

    public List<Subscription> findAllByUserId(int userId) {

        return daoFactory.createSubscriptionDAO().findAllByUserId(userId);}

    public boolean isCardNumberCorrect(String cardNumber) {
        return cardNumber.length() == 19;
    }

    public boolean isCvvCorrect(String cvv) {
        return cvv.length() == 3;
    }
}
