package fr.alardon.escalade.webapp.ressource.photo;

import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class PhotoRessource extends AbstractRessource {

    public UrlPhoto read(int idPhoto){return getManagerFactory().getPhotoManager().read(idPhoto);}

    public List<UrlPhoto> readAllPhotoParSite(int idSite){return getManagerFactory().getPhotoManager().readAllPhotoParSite(idSite);}

    public Integer ajouterUnePhoto(UrlPhoto pUrlPhoto){return getManagerFactory().getPhotoManager().ajouterUnePhoto(pUrlPhoto);}

    public boolean comparaisonUrlPhoto(String pUrlPhoto){return getManagerFactory().getPhotoManager().comparaisonUrlPhoto(pUrlPhoto);}

    public int idDernierePhoto(){return getManagerFactory().getPhotoManager().idDernierePhoto();}

}
