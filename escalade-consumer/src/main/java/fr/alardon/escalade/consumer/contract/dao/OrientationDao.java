package fr.alardon.escalade.consumer.contract.dao;


import fr.alardon.escalade.bean.referentiel.Orientation;

public interface OrientationDao {

    /**
     *
     * @param abreviation
     * @return l'orientation correspondant a son abreviation
     */
    public Orientation read(String abreviation);

}
