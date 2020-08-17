package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.business.contract.manager.PhotoManager;

import javax.inject.Named;
import java.util.List;

@Named
public class PhotoManagerImpl extends AbstractManager implements PhotoManager {

    @Override
    public UrlPhoto read(int idPhoto){return getDaoFactory().getPhotoDao().read(idPhoto);}

    @Override
    public List<UrlPhoto> readAllPhotoParSite(int idSite){return getDaoFactory().getPhotoDao().readAllPhotoParSite(idSite);}

    @Override
    public List<UrlPhoto> readAllPhoto(){return getDaoFactory().getPhotoDao().readAllPhoto();};

    @Override
    public Integer ajouterUnePhoto(UrlPhoto pUrlPhoto){return getDaoFactory().getPhotoDao().ajouterUnePhoto(pUrlPhoto);}

    @Override
    public int idDernierePhoto(){return getDaoFactory().getPhotoDao().idDernierePhoto();}

    @Override
    public boolean comparaisonUrlPhoto(String pUrlPhoto){
        boolean reponse = false;
        List<UrlPhoto> listePhoto;
        listePhoto = readAllPhoto();

        for(UrlPhoto photo:listePhoto) {
            if (photo.getUrl().equals(pUrlPhoto)){
                reponse = true;
            }
        }

        return reponse;
    }

}
