package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.SiteEscalade;

import java.util.List;

public interface SecteurDao {

    /**
     *
     * @return le nombre de secteur
     */
    public int getNbSecteur(int id);

    /**
     *
     * @param id
     * @return le secteur en fonction de l'id du site
     */
    public Secteur read(int id);

    /**
     *
     * @return la liste de tous les secteurs
     */
    public List<Secteur> readAllSecteur();

    /**
     *
     * @param idSite
     * @return le nombre de secteur
     */
    public int readNombreDeSecteur(int idSite);

    /**
     *
     * @param secteur
     * @param siteEscalade
     * @return ajoute un secteur
     */
    public Integer ajouterUnSecteur(Secteur secteur, SiteEscalade siteEscalade);

    /**
     *
     * @return le dernier id secteur entré dans la bdd
     */
    public int idDernierSecteur();
}
