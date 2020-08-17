package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.photo.ListePhotoSite;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.consumer.impl.dao.AbstractDao;

import java.util.List;

public interface ListePhotoDao{

    /**
     *
     * @param idSite
     * @return la liste des photos en fonction du site
     */
    public List<ListePhotoSite> readListePhotoParSite(int idSite);

    /**
     *
     * @param pUrlPhoto
     * @param pSiteEscalade
     * @return ajoute une photo dans la liste
     */
    public Integer ajouterUnePhotoALaListe(UrlPhoto pUrlPhoto, SiteEscalade pSiteEscalade);

}
