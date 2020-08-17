package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.adresse.Adresse;

public interface AdresseDao {
    /**
     *
     * @param pAdresse
     * @return Ajout d'une adresse
     */
    public Integer ajouterUneAdresse(Adresse pAdresse);

    /**
     *
     * @param pAdresse
     * @return ajout d'un adresse sans région et département
     */
    public Integer ajouterUneAdresseSansRegionDepartement(Adresse pAdresse);

    /**
     *
     * @param id
     * @return l'adresse correspondant à l'id
     */
    public Adresse read(int id);

    /**
     *
     * @return la dernière adresse entrée dans la base de données
     */
    public int idDerniereAdresse();

    /**
     *
     * @param pAdresse
     * @return modification d'une adresse sans région et département
     */
    public Integer modifierUneAdresseSansRegionDepartement(Adresse pAdresse);

    /**
     *
     * @param pAdresse
     * @return modification d'une adresse
     */
    public Integer modifierUneAdresse(Adresse pAdresse);
}
