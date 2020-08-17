package fr.alardon.escalade.consumer.impl.rowmapper;


import fr.alardon.escalade.bean.referentiel.Orientation;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class OrientationRM implements RowMapper<Orientation> {

    @Override
    public Orientation mapRow (ResultSet pRS, int pRowNum) throws SQLException {
        Orientation orientation = new Orientation(pRS.getString("abreviation"));
        orientation.setDirection(pRS.getString("direction"));

        return orientation;
    }

}
