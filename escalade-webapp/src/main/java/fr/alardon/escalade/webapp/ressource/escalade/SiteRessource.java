package fr.alardon.escalade.webapp.ressource.escalade;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class SiteRessource extends AbstractRessource {

    public List<SiteEscalade> readAllSiteEscalade(){return getManagerFactory().getSiteManager().readAllSiteEscalade();}

    public List<SiteEscalade> readAllSiteEscaladeSansSecteurPhoto(){return getManagerFactory().getSiteManager().readAllSiteEscaladeSansSecteurPhoto();}

    public SiteEscalade read(int id) {return getManagerFactory().getSiteManager().read(id);}

    public SiteEscalade read(String nomDuSite){return getManagerFactory().getSiteManager().read(nomDuSite);}

    public List<SiteEscalade> readPageDetailSite(){return getManagerFactory().getSiteManager().readPageDetailSite();}

    public List<Cotation> readAllCotation(){return getManagerFactory().getSiteManager().readAllCotation();}

    public List<Orientation> readAllOrientation(){return getManagerFactory().getSiteManager().readAllOrientation();}

    public Integer ajouterUnSite(SiteEscalade siteEscalade){return getManagerFactory().getSiteManager().ajouterUnSite(siteEscalade);}

    public int idDernierSite(){return getManagerFactory().getSiteManager().idDernierSite();}

}
