package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.photo.UrlPhoto;

import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class PhotoRM implements RowMapper<UrlPhoto> {

    @Override
    public UrlPhoto mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        UrlPhoto photo = new UrlPhoto(pRS.getInt("id_photo"));
        photo.setUrl(pRS.getString("url"));
        photo.setDescription(pRS.getString("description"));

        return photo;
    }

}
