package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.photo.ListePhotoSite;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.consumer.contract.dao.ListePhotoDao;
import fr.alardon.escalade.consumer.impl.rowmapper.ListePhotoRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ListePhotoDaoImpl  extends AbstractDao implements ListePhotoDao {

    @Inject
    ListePhotoRM listePhotoRM;

    public List<ListePhotoSite> readListePhotoParSite(int idSite) {
        String vSQL = "SELECT * FROM liste_photo_site as lis\n" +
                "    INNER JOIN site_escalade as sit\n" +
                "    ON sit.id_site = lis.site\n" +
                "    INNER JOIN url_photo as url\n" +
                "    ON url.id_photo = lis.photo\n" +
                "    WHERE sit.id_site = 1";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<ListePhotoSite> vListePhotoSite = vJdbcTemplate.query(vSQL, listePhotoRM);

        return vListePhotoSite;
    }

    @Override
    public Integer ajouterUnePhotoALaListe(UrlPhoto pUrlPhoto, SiteEscalade pSiteEscalade) {
        String vSQL = "INSERT INTO liste_photo_site (site, photo) VALUES (:site, :photo) ";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("photo", pUrlPhoto.getIdUrl());
        vParams.addValue("site", pSiteEscalade.getIdSite());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }




}
