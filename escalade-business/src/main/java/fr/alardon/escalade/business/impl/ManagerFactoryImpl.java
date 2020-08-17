package fr.alardon.escalade.business.impl;

import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.business.contract.ManagerFactory;
import fr.alardon.escalade.business.contract.manager.*;
import fr.alardon.escalade.consumer.contract.dao.ListeCommentaireDao;
import fr.alardon.escalade.consumer.contract.dao.ListeTopoDao;
import fr.alardon.escalade.consumer.contract.dao.TopoDao;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Classe qui retourne des Managers pour toutes les tables de la base de données.
 *
 * @author alardon
 *
 */

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    //-- Les Objets à injecter ici
    @Inject
    private UtilisateurManager utilisateurManager;

    @Inject
    private AdresseManager adresseManager;

    @Inject
    private PaysManager paysManager;

    @Inject
    private DepartementManager departementManager;

    @Inject
    private RegionManager regionManager;

    @Inject
    private SiteManager siteManager;

    @Inject
    private SecteurManager secteurManager;

    @Inject
    private VoieManager voieManager;

    @Inject
    private PhotoManager photoManager;

    @Inject
    private ListePhotoManager listePhotoManager;

    @Inject
    private CommentaireManager commentaireManager;

    @Inject
    private ListeCommentaireManager listeCommentaireManager;

    @Inject
    private TopoManager topoManager;

    @Inject
    private ListeTopoManager listeTopoManager;

    @Inject
    private OrientationManager orientationManager;


    //-- Manager : Getter et Setter
    //----------------
    //-- UTILISATEUR
    //----------------
    @Override
    public UtilisateurManager getUtilisateurManager() {
        return utilisateurManager;
    }

    @Override
    public void setUtilisateurManager(UtilisateurManager pUtilisateurManager) {utilisateurManager = pUtilisateurManager;}

    //----------------
    //-- ADRESSE
    //----------------
    @Override
    public AdresseManager getAdresseManager() {return adresseManager;}

    @Override
    public void setAdresseManager(AdresseManager pAdresseManager) {adresseManager = pAdresseManager;}

    //----------------
    //-- PAYS
    //----------------
    @Override
    public PaysManager getPaysManager() {return paysManager;}

    @Override
    public void setPaysManager(PaysManager paysManager) {this.paysManager = paysManager;}

    //----------------
    //-- DEPARTEMENT
    //----------------
    @Override
    public DepartementManager getDepartementManager() {
        return departementManager;
    }

    @Override
    public void setDepartementManager(DepartementManager departementManager) {this.departementManager = departementManager;}

    //----------------
    //-- REGION
    //----------------
    @Override
    public RegionManager getRegionManager() {return regionManager;}

    @Override
    public void setRegionManager(RegionManager regionManager) {this.regionManager = regionManager;}

    //----------------
    //-- SITE ESCALADE
    //----------------

    @Override
    public SiteManager getSiteManager() {return siteManager;}

    @Override
    public void setSiteManager(SiteManager siteManager) {this.siteManager = siteManager;}

    //----------------
    //-- SECTEUR
    //----------------

    @Override
    public SecteurManager getSecteurManager() {return secteurManager;}

    @Override
    public void setSecteurManager(SecteurManager secteurManager) {this.secteurManager = secteurManager;}

    //----------------
    //-- VOIE
    //----------------

    @Override
    public VoieManager getVoieManager() {return voieManager;}

    @Override
    public void setVoieManager(VoieManager voieManager) {this.voieManager = voieManager;}

    //----------------
    //-- PHOTO
    //----------------

    @Override
    public PhotoManager getPhotoManager() {return photoManager;}

    @Override
    public void setPhotoManager(PhotoManager photoManager) {this.photoManager = photoManager;}

    //----------------
    //-- LISTE PHOTO
    //----------------

    @Override
    public ListePhotoManager getListePhotoManager() {return listePhotoManager;}

    @Override
    public void setListePhotoManager(ListePhotoManager pListePhotoManager) {this.listePhotoManager = pListePhotoManager;}

    //----------------
    //-- COMMENTAIRE
    //----------------

    @Override
    public CommentaireManager getCommentaireManager() {return commentaireManager;}

    @Override
    public void setCommentaireManager(CommentaireManager commentaireManager) {this.commentaireManager = commentaireManager;}

    //----------------
    //-- LISTE COMMENTAIRE
    //----------------

    @Override
    public ListeCommentaireManager getListeCommentaireManager() {return listeCommentaireManager;}

    @Override
    public void setListeCommentaireManager(ListeCommentaireManager pListeCommentaireManager) {this.listeCommentaireManager = pListeCommentaireManager;}

    //----------------
    //-- TOPO
    //----------------

    @Override
    public TopoManager getTopoManager() {return topoManager;}

    @Override
    public void setTopoManager(TopoManager pTopoManager) {this.topoManager = pTopoManager;}


    //----------------
    //-- LISTE TOPO
    //----------------
    @Override
    public ListeTopoManager getListeTopoManager() {return listeTopoManager;}

    @Override
    public void setListeTopoManager(ListeTopoManager pListeTopoManager) {this.listeTopoManager = pListeTopoManager;}

    //----------------
    //-- ORIENTATION
    //----------------

    @Override
    public OrientationManager getOrientationManager() {return orientationManager;}

    @Override
    public void setOrientationManager(OrientationManager pOrientationManager) {this.orientationManager = pOrientationManager;}
}
