package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.bean.site.SiteEscalade;

import java.util.List;

public interface SiteManager {

    public List<SiteEscalade> readAllSiteEscalade();

    public List<SiteEscalade> readAllSiteEscaladeSansSecteurPhoto();

    public SiteEscalade read(int id);

    public SiteEscalade read(String nomDuSite);

    public List<SiteEscalade> readPageDetailSite();

    public List<Cotation> readAllCotation();

    public List<Orientation> readAllOrientation();

    public Integer ajouterUnSite(SiteEscalade siteEscalade);

    public int idDernierSite();

}
