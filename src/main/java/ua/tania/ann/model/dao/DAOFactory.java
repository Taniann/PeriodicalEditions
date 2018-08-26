package ua.tania.ann.model.dao;


import ua.tania.ann.model.dao.impl.DAOFactoryImpl;

/**
 * Created by Таня on 17.08.2018.
 */
public abstract class DAOFactory {
    private static DAOFactory daoFactory;

    public abstract UserDAO createUserDAO();
    public abstract EditionDAO createEditionDAO();
    public abstract CategoryDAO createCategoryDAO();


    public static DAOFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DAOFactory.class){
                if(daoFactory==null){
                    daoFactory = new DAOFactoryImpl();;
                }
            }
        }
        return daoFactory;
    }
}
