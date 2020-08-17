package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.bean.site.SiteEscalade;


import java.util.List;

public interface SiteDao {

    /**
     *
     * @return la liste complète des sites d'escalade
     */
     public List<SiteEscalade> readAllSiteEscalade();

    /**
     *
     * @return la liste complète des sites d'escalade, sans secteur, voie et photo
     */
    public List<SiteEscalade> readAllSiteEscaladeSansSecteurPhoto();

    /**
     *
     * @param id
     * @return le site d'escalade correspondant à l'id
     */
    public SiteEscalade read(int id);

    /**
     *
     * @param nomDuSite
     * @return le site d'escalade correspondant au nom du site
     *
     */
    public SiteEscalade read(String nomDuSite);

    /**
     *
     * @return les détail du site permettant de remplir la page des sites
     */
    public List<SiteEscalade> readPageDetailSite();

    /**
     *
     * @param idSite
     * @return la cotation min du site
     */
    public String readCotationSiteMin(int idSite);

    /**
     *
     * @param idSite
     * @return la cotation max du site
     */
    public String readCotationSiteMax(int idSite);

    /**
     *
     * @return la liste des cotations
     */
    public List<Cotation> readAllCotation();

    /**
     *
     * @return la liste des orientations
     */
    public List<Orientation> readAllOrientation();

    /**
     *
     * @param siteEscalade
     * @return ajoute un site d'escalade
     */
    public Integer ajouterUnSite(SiteEscalade siteEscalade);

    /**
     *
     * @return recuperation du dernier id
     */
    public int idDernierSite();


}
