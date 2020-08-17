package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.photo.UrlPhoto;


import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.PhotoDao;
import fr.alardon.escalade.consumer.impl.rowmapper.PhotoRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PhotoDaoImpl extends AbstractDao implements PhotoDao {

    @Inject
    PhotoRM photoRM;

    @Override
    public UrlPhoto read(int idPhoto) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            String vSQL = "SELECT * FROM url_photo WHERE id_photo=" + idPhoto;

            List<UrlPhoto> listPhoto = jdbcTemplate.query(vSQL, photoRM);
            UrlPhoto urlPhoto = listPhoto.get(0);
        return urlPhoto;
    }

    @Override
    public List<UrlPhoto> readAllPhotoParSite(int idSite) {
        String vSQL = "SELECT url.id_photo, url.url, url.description FROM url_photo as url\n" +
                "INNER JOIN liste_photo_site as lis\n" +
                "ON url.id_photo = lis.photo\n" +
                "INNER JOIN site_escalade as sit\n" +
                "ON lis.site = sit.id_site\n" +
                "WHERE id_site =" + idSite;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<UrlPhoto> listPhoto = vJdbcTemplate.query(vSQL, photoRM);


        return listPhoto;
    }

    @Override
    public List<UrlPhoto> readAllPhoto(){
        String vSQL = "SELECT * FROM url_photo";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<UrlPhoto> listePhoto = vJdbcTemplate.query(vSQL, photoRM);

        return listePhoto;
    }

    public Integer ajouterUnePhoto(UrlPhoto pUrlPhoto){

        String vSQL = "INSERT INTO url_photo (url, description) VALUES (:url, :description)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("url", pUrlPhoto.getUrl());
        vParams.addValue("description", pUrlPhoto.getDescription());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public int idDernierePhoto(){

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT currval(pg_get_serial_sequence('url_photo', 'id_photo'))";
        int id = vJdbcTemplate.queryForObject(vSQL, Integer.class);

        return id;
    }

}
