package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.photo.ListePhotoSite;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.site.SiteEscalade;

import java.util.List;

public interface ListePhotoManager {

    public List<ListePhotoSite> readListePhotoParSite(int idSite);

    public Integer ajouterUnePhotoALaListe(UrlPhoto pUrlPhoto, SiteEscalade pSiteEscalade);

}
