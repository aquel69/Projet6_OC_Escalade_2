package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.referentiel.Departement;
import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.consumer.contract.dao.DepartementDao;
import fr.alardon.escalade.consumer.impl.rowmapper.DepartementRM;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DepartementDaoImpl extends AbstractDao implements DepartementDao {

    @Inject
    DepartementRM departementRM;

    @Override
    public List<Departement> readAllDepartement() {
        String vSQL = "SELECT * FROM departement";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Departement> vListDepartement = vJdbcTemplate.query(vSQL, departementRM);

        return vListDepartement;
    }

    @Override
    public Departement read(String nom) {
        Departement departement = null;
        if(!nom.isEmpty()) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            String vSQL = "SELECT * FROM departement WHERE nom=\'" + nom + "\'";

            List<Departement> listDepartement = jdbcTemplate.query(vSQL, departementRM);
            departement = listDepartement.get(0);
        }

        return departement;
    }

    @Override
    public Departement read(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM departement WHERE id_departement="+id;
        List<Departement> listDepartement = jdbcTemplate.query(vSQL, departementRM);
        Departement departement = listDepartement.get(0);

        return departement;
    }

}
