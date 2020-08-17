package fr.alardon.escalade.consumer.contract;


import fr.alardon.escalade.consumer.contract.dao.*;

public interface DaoFactory {

    //----- UTILISATEUR -----
    UtilisateurDao getUtilisateurDao();

    void setUtilisateurDao(UtilisateurDao pUtilisateurDao);

    //----- ADRESSE -----
    AdresseDao getAdresseDao();

    void setAdresseDao(AdresseDao pAdresseDao);

    //----- PAYS -----
    PaysDao getPaysDao();

    void setPaysDao(PaysDao pPaysDao);

    //----- DEPARTEMENT -----
    DepartementDao getDepartementDao();

    void setDepartementDao(DepartementDao pDepartementDao);

    //----- REGION -----

    RegionDao getRegionDao();

    void setRegionDao(RegionDao pRegionDao);

    //----- SITE -----

    SiteDao getSiteDao();

    void setSiteDao(SiteDao pSiteDao);

    //----- SECTEUR  -----

    SecteurDao getSecteurDao();

    void setSecteurDao(SecteurDao pSecteurDao);

    //----- SECTEUR  -----

    VoieDao getVoieDao();

    void setVoieDao(VoieDao pVoieDao);

    //----- PHOTO  -----

    PhotoDao getPhotoDao();

    void setPhotoDao(PhotoDao pPhotoDao);

    //----- LISTE PHOTO  -----

    ListePhotoDao getListePhotoDao();

    void setListePhotoDao(ListePhotoDao pListePhotoDao);

    //----- COMMENTAIRE  -----

    CommentaireDao getCommentaireDao();

    void setCommentaireDao(CommentaireDao pCommentaireDao);

    //----- LISTE COMMENTAIRE  -----

    public ListeCommentaireDao getListeCommentaireDao();

    void setListeCommentaireDao(ListeCommentaireDao pListeCommentaireDao);

    //----- TOPO  -----

    TopoDao getTopoDao();

    void setTopoDao(TopoDao pTopoDao);

    //----- LISTE TOPO  -----

    public ListeTopoDao getListeTopoDao();

    void setListeTopoDao(ListeTopoDao pListeTopoDao);

    //----- ORIENTATION  -----

    public OrientationDao getOrientationDao();

    void setOrientationDao(OrientationDao pOrientationDao);


}
