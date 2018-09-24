package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.User;

/**
 * Created by Таня on 09.09.2018.
 */
public class PaymentService {
    private static volatile PaymentService instance;

    private DAOFactory daoFactory;

    private PaymentService() {daoFactory = DAOFactory.getInstance();}

    public static PaymentService getInstance() {
        if(instance == null){
            synchronized (PaymentService.class){
                if (instance == null){
                    instance = new PaymentService();
                }
            }
        }
        return instance;
    }


    /**
     * Check if user`s card balance is not enough for paying
     * @param user
     * @param totalAmount
     */
    public boolean isBalanceNotEnough(User user, Double totalAmount) {
        return user.getCardBalance() < totalAmount;
    }

    /**
     * Calculate new user`s card balance after paying
     * @param user
     * @param totalAmount
     */
    public Double getNewBalanceForInsert(User user, Double totalAmount) {
        return user.getCardBalance() - totalAmount;
    }

}
