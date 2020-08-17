package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.referentiel.Departement;
import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.consumer.contract.dao.RegionDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class DepartementRM implements RowMapper<Departement> {
    @Inject
    RegionDao regionDaoImpl;

    @Override
    public Departement mapRow (ResultSet pRS, int pRowNum) throws SQLException {
        Departement departement = new Departement(pRS.getInt("id_departement"));
        departement.setNumero(pRS.getString("numero"));
        departement.setNom(pRS.getString("nom"));

        Region vRegion = regionDaoImpl.read(pRS.getInt("id_region"));
        departement.setRegion(vRegion);

        return departement;
    }
}
