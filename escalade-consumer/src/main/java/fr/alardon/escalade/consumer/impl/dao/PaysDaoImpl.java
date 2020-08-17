package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.referentiel.Pays;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.PaysDao;
import fr.alardon.escalade.consumer.impl.rowmapper.PaysRM;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PaysDaoImpl extends AbstractDao implements PaysDao {

    @Inject
    PaysRM paysRM;

    @Override
    public List<Pays> readAllPays(){
        String vSQL = "SELECT * FROM pays";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pays> vListPays = vJdbcTemplate.query(vSQL, paysRM);

        return vListPays;
    }

    @Override
    public Pays read(int id) {
        Pays pays = null;
        String stringId = String.valueOf(id);
        if(!stringId.isEmpty()) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            String vSQL = "SELECT * FROM pays WHERE pays_code=" + id;

            List<Pays> listPays = jdbcTemplate.query(vSQL, paysRM);
            pays = listPays.get(0);
        }
        return pays;
    }

    @Override
    public Pays read(String nom) {
        Pays pays = null;
        if(!nom.isEmpty()) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            String vSQL = "SELECT * FROM pays WHERE nom=\'" + nom + "\'";

            List<Pays> listPays = jdbcTemplate.query(vSQL, paysRM);
            pays = listPays.get(0);
        }

        return pays;
    }

}

