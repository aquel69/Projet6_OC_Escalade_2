package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.referentiel.Pays;

import java.util.List;

public interface PaysDao {

    /**
     *
     * @return la liste de tous les pays
     */
    public List<Pays> readAllPays();

    /**
     *
     * @param id
     * @return le pays correspondant à partir de son id
     */
    public Pays read(int id);

    /**
     *
     * @param nom
     * @return le pays correspondant à partir de son nom
     */
    public Pays read(String nom);
}
