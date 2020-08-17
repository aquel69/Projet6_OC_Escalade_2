package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.Voie;

import java.util.List;

public interface VoieDao {

    /**
     *
     * @param idSite
     * @return retourne les voies du site
     */
    public List<Voie> readVoieRapportSite(int idSite);

    /**
     *
     * @param idSite
     * @return le nombre de voie
     */
    public int readNombreDeVoie(int idSite);

    /**
     *
     * @param voie
     * @param secteur
     * @param cotation
     * @return ajoute une voie
     */
    public Integer ajouterUneVoie(Voie voie, Secteur secteur, Cotation cotation);

}
