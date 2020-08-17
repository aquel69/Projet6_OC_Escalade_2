package fr.alardon.escalade.webapp.ressource;


import fr.alardon.escalade.business.contract.ManagerFactory;

public abstract class AbstractRessource {

    /**
     * Classe abstraite en charge de récupérer L'objet ManagerFactory.
     *
     * @author alardon
     */

    //-- Variable d'instances
    private static ManagerFactory managerFactory;

    //-- GETTER
    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    //-- SETTER
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }


}
