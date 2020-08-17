package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.referentiel.Departement;

import java.util.List;

public interface DepartementDao {
    /**
     *
     * @return la liste de tous les Departement
     */
    public List<Departement> readAllDepartement();

    /**
     *
     * @param nom
     * @return le Departement complet en fonction de son nom
     */
    public Departement read(String nom);

    /**
     *
     * @param id
     * @return le Departement complet en fonction de son id
     */
    public Departement read(int id);

}
