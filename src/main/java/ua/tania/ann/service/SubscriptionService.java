package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.Subscription;
import ua.tania.ann.model.entity.User;

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

    /**
     * Paying and adding subscriptions
     * @param subscriptions
     * @param user
     */
    public boolean insertWithPay(List<Subscription> subscriptions, User user) {
        return daoFactory.createSubscriptionDAO().insertWithPay(subscriptions, user) == subscriptions.size();
    }

    /**
     * Get all subscriptions be user`s id
     * @param userId
     */
    public List<Subscription> findAllByUserId(int userId) {

        return daoFactory.createSubscriptionDAO().findAllByUserId(userId);}

    /**
     * Check if card number is correct
     * @param cardNumber
     */
    public boolean isCardNumberCorrect(String cardNumber) {
        return cardNumber.length() == 19;
    }

    /**
     * Check if CVV is correct
     * @param cvv
     */
    public boolean isCvvCorrect(String cvv) {
        return cvv.length() == 3;
    }

}
