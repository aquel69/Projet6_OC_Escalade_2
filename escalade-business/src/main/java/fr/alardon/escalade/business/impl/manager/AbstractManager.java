package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.consumer.contract.DaoFactory;

/**
 * Classe abstraite en charge de récupérer L'objet DaoFactoryImpl.
 *
 * @author alardon
 *
 */
public abstract class AbstractManager {
    //-- Variable d'instances
    private static DaoFactory daoFactory;

    //-- GETTER
    protected static DaoFactory getDaoFactory() {
        return daoFactory;
    }

    //-- SETTER
    public static void setDaoFactory(DaoFactory pDaoFactory) {
        daoFactory = pDaoFactory;
    }
}
