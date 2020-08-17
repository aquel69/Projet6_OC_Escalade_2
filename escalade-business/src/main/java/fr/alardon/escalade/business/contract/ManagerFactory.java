package fr.alardon.escalade.business.contract;


import fr.alardon.escalade.business.contract.manager.*;
import fr.alardon.escalade.consumer.contract.dao.CommentaireDao;
import fr.alardon.escalade.consumer.contract.dao.DepartementDao;
import fr.alardon.escalade.consumer.contract.dao.ListeCommentaireDao;

public interface ManagerFactory {
    //----------------
    //-- UTILISATEUR
    //----------------

    UtilisateurManager getUtilisateurManager();

    void setUtilisateurManager(UtilisateurManager pUtilisateurManager);

    ///----------------
    //-- ADRESSE
    //-----------------

    AdresseManager getAdresseManager();

    void setAdresseManager(AdresseManager pAdresseManager);

    ///----------------
    //-- PAYS
    //-----------------

    PaysManager getPaysManager();

    void setPaysManager(PaysManager pPaysManager);

    ///----------------
    //-- DEPARTEMENT
    //-----------------

    DepartementManager getDepartementManager();

    void setDepartementManager(DepartementManager pDepartementManager);

    ///----------------
    //-- REGION
    //-----------------

    RegionManager getRegionManager();

    void setRegionManager(RegionManager pRegionManager);

    ///----------------
    //-- SITE ESCALADE
    //-----------------

    SiteManager getSiteManager();

    void setSiteManager(SiteManager pSiteManager);

    ///----------------
    //-- SECTEUR
    //-----------------

    SecteurManager getSecteurManager();

    void setSecteurManager(SecteurManager pSecteurManager);

    ///----------------
    //-- VOIE
    //-----------------

    VoieManager getVoieManager();

    void setVoieManager(VoieManager pVoieManager);

    ///----------------
    //-- PHOTO
    //-----------------

    PhotoManager getPhotoManager();

    void setPhotoManager(PhotoManager pPhotoManager);

    ///----------------
    //-- LISTE PHOTO
    //-----------------

    ListePhotoManager getListePhotoManager();

    void setListePhotoManager(ListePhotoManager pListePhotoManager);

    ///----------------
    //-- COMMENTAIRE
    //-----------------

    CommentaireManager getCommentaireManager();

    void setCommentaireManager(CommentaireManager pCommentaireManager);

    ///----------------
    //-- LISTE COMMENTAIRE
    //-----------------

    ListeCommentaireManager getListeCommentaireManager();

    void setListeCommentaireManager(ListeCommentaireManager pListeCommentaireManager);

    //----------------
    //-- TOPO
    //----------------

    TopoManager getTopoManager();

    void setTopoManager(TopoManager pTopoManager);

    //----------------
    //-- LISTE TOPO
    //----------------

    public ListeTopoManager getListeTopoManager();

    void setListeTopoManager(ListeTopoManager pListeTopoManager);

    //----------------
    //-- ORIENTATION
    //----------------

    public OrientationManager getOrientationManager();

    void setOrientationManager(OrientationManager pOrientationManager);
}