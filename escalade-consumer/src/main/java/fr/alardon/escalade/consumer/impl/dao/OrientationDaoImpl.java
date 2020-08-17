package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.consumer.contract.dao.OrientationDao;
import fr.alardon.escalade.consumer.impl.rowmapper.OrientationRM;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class OrientationDaoImpl extends AbstractDao implements OrientationDao {

    @Inject
    OrientationRM orientationRM;

    @Override
    public Orientation read(String abreviation) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM orientation WHERE abreviation=\'" + abreviation + "\'";

        List<Orientation> listOrientation = jdbcTemplate.query(vSQL, orientationRM);
        Orientation orientation = listOrientation.get(0);

        return orientation;
    }

}
