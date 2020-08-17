package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.photo.ListePhotoSite;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.business.contract.manager.ListePhotoManager;
import fr.alardon.escalade.consumer.impl.dao.AbstractDao;

import javax.inject.Named;
import java.util.List;

@Named
public class ListePhotoManagerImpl extends AbstractManager implements ListePhotoManager {

    @Override
    public List<ListePhotoSite> readListePhotoParSite(int idSite){return getDaoFactory().getListePhotoDao().readListePhotoParSite(idSite);}

    @Override
    public Integer ajouterUnePhotoALaListe(UrlPhoto pUrlPhoto, SiteEscalade pSiteEscalade){return getDaoFactory().getListePhotoDao().ajouterUnePhotoALaListe(pUrlPhoto, pSiteEscalade);}

}
