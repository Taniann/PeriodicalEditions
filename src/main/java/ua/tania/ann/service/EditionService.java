package ua.tania.ann.service;

import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.entity.Edition;

/**
 * Created by Таня on 17.08.2018.
 */
public class EditionService {
    private static EditionService instance;

    private DAOFactory factory;

    private EditionService(){
        factory = DAOFactory.getInstance();
    }

    public static EditionService getInstance(){
        if(instance == null){
            synchronized (EditionService.class){
                if (instance == null){
                    instance = new EditionService();
                }
            }
        }
        return instance;
    }

    public boolean insert(Edition edition) {
        return factory.createEditionDAO().insert(edition);
    }
}
