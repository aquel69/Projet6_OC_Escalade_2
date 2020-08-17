package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.photo.UrlPhoto;

import java.util.List;

public interface PhotoManager {

    public UrlPhoto read(int idPhoto);

    public List<UrlPhoto> readAllPhotoParSite(int idSite);

    public Integer ajouterUnePhoto(UrlPhoto pUrlPhoto);

    public List<UrlPhoto> readAllPhoto();

    public boolean comparaisonUrlPhoto(String pUrlPhoto);

    public int idDernierePhoto();

}
