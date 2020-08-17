package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.photo.ListePhotoSite;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.consumer.contract.dao.PhotoDao;
import fr.alardon.escalade.consumer.contract.dao.SiteDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class ListePhotoRM implements RowMapper<ListePhotoSite> {

    @Inject
    PhotoDao photoDaoImpl;

    @Inject
    SiteDao siteDaoImpl;

    public ListePhotoSite mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        ListePhotoSite listePhotoSite = new ListePhotoSite(pRS.getInt("id_liste_photo"));

        UrlPhoto vUrlPhoto = photoDaoImpl.read(pRS.getInt("photo"));
        listePhotoSite.setUrlPhoto(vUrlPhoto);

        SiteEscalade vSiteEscalade = siteDaoImpl.read(pRS.getInt("site"));
        listePhotoSite.setSiteEscalade(vSiteEscalade);


        return listePhotoSite;
    }

}
