package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.photo.UrlPhoto;

import java.util.List;

public interface PhotoDao {

    /**
     *
     * @param idPhoto
     * @return la photo suivant son id
     */
    public UrlPhoto read(int idPhoto);

    /**
     *
     * @param idSite
     * @return la liste des photos par site
     */
    public List<UrlPhoto> readAllPhotoParSite(int idSite);

    /**
     *
     * @param pUrlPhoto
     * @return ajoute une photo
     */
    public Integer ajouterUnePhoto(UrlPhoto pUrlPhoto);

    /**
     *
     * @return toutes les photos
     */
    public List<UrlPhoto> readAllPhoto();

    /**
     *
     * @return l'id de la dernière photo
     */
    public int idDernierePhoto();

}
