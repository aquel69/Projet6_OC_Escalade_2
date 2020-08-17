package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.business.contract.manager.SecteurManager;
import fr.alardon.escalade.consumer.contract.dao.SecteurDao;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

    @Override
    public int getNbSecteur(int id) {return getDaoFactory().getSecteurDao().getNbSecteur(id);}

    @Override
    public Secteur read(int id){return getDaoFactory().getSecteurDao().read(id);}

    @Override
    public List<Secteur> readAllSecteur(){return getDaoFactory().getSecteurDao().readAllSecteur();}

    @Override
    public Integer ajouterUnSecteur(Secteur secteur, SiteEscalade siteEscalade){return getDaoFactory().getSecteurDao().ajouterUnSecteur(secteur, siteEscalade);}

    @Override
    public int idDernierSecteur(){return getDaoFactory().getSecteurDao().idDernierSecteur();}
}
