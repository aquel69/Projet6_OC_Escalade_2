package fr.alardon.escalade.consumer.impl;

import fr.alardon.escalade.consumer.contract.DaoFactory;
import fr.alardon.escalade.consumer.contract.dao.*;

import fr.alardon.escalade.consumer.impl.dao.DepartementDaoImpl;

import javax.inject.Inject;
import javax.inject.Named;

@Named("daoFactory")
public class DaoFactoryImpl implements DaoFactory {

    @Inject
    private UtilisateurDao utilisateurDaoImpl;

    @Inject
    private AdresseDao adresseDaoImpl;

    @Inject
    private PaysDao paysDaoImpl;

    @Inject
    private DepartementDao departementDaoImpl;

    @Inject
    private RegionDao regionDaoImpl;

    @Inject
    private SiteDao siteDaoImpl;

    @Inject
    private SecteurDao secteurDaoImpl;

    @Inject
    private VoieDao voieDaoImpl;

    @Inject
    private ListePhotoDao listePhotoDaoImpl;

    @Inject
    private PhotoDao photoDaoImpl;

    @Inject
    private CommentaireDao commentaireDaoImpl;

    @Inject
    private ListeCommentaireDao listeCommentaireDaoImpl;

    @Inject
    private TopoDao topoDaoImpl;

    @Inject
    private ListeTopoDao listeTopoDaoImpl;

    @Inject
    private OrientationDao orientationDaoImpl;

   //----- UTILISATEUR -----
    @Override
    public UtilisateurDao getUtilisateurDao() {
        return utilisateurDaoImpl;
    }

    @Override
    public void setUtilisateurDao(UtilisateurDao pUtilisateurDao) {
        this.utilisateurDaoImpl = pUtilisateurDao;
    }

    //----- ADRESSE -----
    @Override
    public AdresseDao getAdresseDao() {
        return adresseDaoImpl;
    }

    @Override
    public void setAdresseDao(AdresseDao pAdresseDao) {this.adresseDaoImpl = pAdresseDao;}

    //----------------
    //-- PAYS
    //----------------
    @Override
    public PaysDao getPaysDao() {return paysDaoImpl;}

    @Override
    public void setPaysDao(PaysDao pPaysDao) { this.paysDaoImpl = pPaysDao;}

    //----------------
    //-- DEPARTEMENT
    //----------------
    @Override
    public DepartementDao getDepartementDao() {return departementDaoImpl;}

    @Override
    public void setDepartementDao(DepartementDao pDepartementDao) { this.departementDaoImpl = pDepartementDao;}

    //----------------
    //-- REGION
    //----------------
    @Override
    public RegionDao getRegionDao() {return regionDaoImpl;}

    @Override
    public void setRegionDao(RegionDao pRegionManager) {this.regionDaoImpl = pRegionManager;}

    //----------------
    //-- SITE ESCALADE
    //----------------

    @Override
    public SiteDao getSiteDao() {return siteDaoImpl;}

    @Override
    public void setSiteDao(SiteDao pSiteDao) {this.siteDaoImpl = pSiteDao;}

    //----------------
    //-- SECTEUR
    //----------------

    @Override
    public SecteurDao getSecteurDao() {return secteurDaoImpl;}

    @Override
    public void setSecteurDao(SecteurDao pSecteurDao) {this.secteurDaoImpl = pSecteurDao;}

    //----------------
    //-- VOIE
    //----------------

    @Override
    public VoieDao getVoieDao() {return voieDaoImpl;}

    @Override
    public void setVoieDao(VoieDao pVoieDao) {this.voieDaoImpl = pVoieDao;}


    //----------------
    //-- LISTE PHOTO
    //----------------

    @Override
    public ListePhotoDao getListePhotoDao() {return listePhotoDaoImpl;}

    @Override
    public void setListePhotoDao(ListePhotoDao pListePhotoDao) {this.listePhotoDaoImpl = pListePhotoDao;}

    //----------------
    //-- PHOTO
    //----------------

    @Override
    public PhotoDao getPhotoDao(){return photoDaoImpl;}

    @Override
    public  void setPhotoDao(PhotoDao pPhotoDao) {this.photoDaoImpl = pPhotoDao;}

    //----------------
    //-- COMMENTAIRE
    //----------------

    @Override
    public CommentaireDao getCommentaireDao() {return commentaireDaoImpl;}

    @Override
    public void setCommentaireDao(CommentaireDao pCommentaireDao) {this.commentaireDaoImpl = pCommentaireDao;}

    //----------------
    //-- LISTE COMMENTAIRE
    //----------------

    @Override
    public ListeCommentaireDao getListeCommentaireDao() {return listeCommentaireDaoImpl;}

    @Override
    public void setListeCommentaireDao(ListeCommentaireDao pListeCommentaireDao) {this.listeCommentaireDaoImpl = pListeCommentaireDao;}

    //----------------
    //-- TOPO
    //----------------

    @Override
    public TopoDao getTopoDao() {return topoDaoImpl;}

    @Override
    public void setTopoDao(TopoDao pTopoDao) {this.topoDaoImpl = pTopoDao;}


    //----------------
    //-- LISTE TOPO
    //----------------
    @Override
    public ListeTopoDao getListeTopoDao() {return listeTopoDaoImpl;}

    @Override
    public void setListeTopoDao(ListeTopoDao pListeTopoDao) {this.listeTopoDaoImpl = pListeTopoDao;}

    //----------------
    //-- LISTE TOPO
    //----------------

    @Override
    public OrientationDao getOrientationDao() {return orientationDaoImpl;}

    @Override
    public void setOrientationDao(OrientationDao pOrientationDao) {this.orientationDaoImpl = pOrientationDao;}
}
