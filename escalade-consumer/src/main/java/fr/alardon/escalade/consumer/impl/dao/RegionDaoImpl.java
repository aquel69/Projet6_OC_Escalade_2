package fr.alardon.escalade.consumer.impl.dao;


import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.consumer.contract.dao.RegionDao;
import fr.alardon.escalade.consumer.impl.rowmapper.RegionRM;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class RegionDaoImpl extends AbstractDao implements RegionDao {
    @Inject
    RegionRM regionRM;

    @Override
    public List<Region> readAllRegion() {
        String vSQL = "SELECT * FROM region";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Region> vListRegion = vJdbcTemplate.query(vSQL, regionRM);

        return vListRegion;

    }

    @Override
    public Region read(String nom) {
        Region region = null;
        if(!nom.isEmpty()) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            String vSQL = "SELECT * FROM region WHERE nom=\'" + nom + "\'";

            List<Region> listRegion = jdbcTemplate.query(vSQL, regionRM);
            region = listRegion.get(0);
        }
        return region;
    }

    @Override
    public Region read(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM region WHERE id_region="+id;

        List<Region> listRegion = jdbcTemplate.query(vSQL, regionRM);
        Region region = listRegion.get(0);

        return region;
    }
}
