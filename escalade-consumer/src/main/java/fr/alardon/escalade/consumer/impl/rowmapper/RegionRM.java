package fr.alardon.escalade.consumer.impl.rowmapper;


import fr.alardon.escalade.bean.referentiel.Pays;
import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.consumer.contract.dao.PaysDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RegionRM implements RowMapper<Region> {
    @Inject
    PaysDao paysDaoImpl;

    @Override
    public Region mapRow (ResultSet pRS, int pRowNum) throws SQLException {
        Region region = new Region(pRS.getInt("id_region"));
        region.setNom(pRS.getString("nom"));

        Pays vPays = paysDaoImpl.read(pRS.getInt("pays_code"));
        region.setPays(vPays);

        return region;
    }
}
