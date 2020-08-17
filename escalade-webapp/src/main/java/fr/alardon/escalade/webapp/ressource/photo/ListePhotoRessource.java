package fr.alardon.escalade.webapp.ressource.photo;

import fr.alardon.escalade.bean.photo.ListePhotoSite;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class ListePhotoRessource extends AbstractRessource {

    public List<ListePhotoSite> readListePhotoParSite(int idSite){return getManagerFactory().getListePhotoManager().readListePhotoParSite(idSite);}

    public Integer ajouterUnePhotoALaListe(UrlPhoto pUrlPhoto, SiteEscalade pSiteEscalade){return getManagerFactory().getListePhotoManager().ajouterUnePhotoALaListe(pUrlPhoto,pSiteEscalade);}

}
