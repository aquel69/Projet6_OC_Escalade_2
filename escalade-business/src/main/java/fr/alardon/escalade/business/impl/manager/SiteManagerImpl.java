package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.business.contract.ManagerFactory;
import fr.alardon.escalade.business.contract.manager.SiteManager;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {

    @Override
    public List<SiteEscalade> readAllSiteEscalade() {return getDaoFactory().getSiteDao().readAllSiteEscalade();}

    @Override
    public List<SiteEscalade> readAllSiteEscaladeSansSecteurPhoto(){return getDaoFactory().getSiteDao().readAllSiteEscaladeSansSecteurPhoto();}

    @Override
    public SiteEscalade read(int id) {return getDaoFactory().getSiteDao().read(id);}

    @Override
    public SiteEscalade read(String nomDuSite){return getDaoFactory().getSiteDao().read(nomDuSite);}

    @Override
    public List<SiteEscalade> readPageDetailSite() {return getDaoFactory().getSiteDao().readPageDetailSite();}

    @Override
    public List<Cotation> readAllCotation(){return getDaoFactory().getSiteDao().readAllCotation();}

    @Override
    public List<Orientation> readAllOrientation(){return getDaoFactory().getSiteDao().readAllOrientation();}

    @Override
    public Integer ajouterUnSite(SiteEscalade siteEscalade){return getDaoFactory().getSiteDao().ajouterUnSite(siteEscalade);}

    @Override
    public int idDernierSite(){return getDaoFactory().getSiteDao().idDernierSite();}
}
