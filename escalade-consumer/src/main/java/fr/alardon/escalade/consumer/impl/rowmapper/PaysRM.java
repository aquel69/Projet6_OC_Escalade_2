package fr.alardon.escalade.consumer.impl.rowmapper;


import fr.alardon.escalade.bean.referentiel.Pays;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class PaysRM implements RowMapper<Pays> {
    @Override
    public Pays mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        Pays pays = new Pays(pRS.getInt("pays_code"));
        pays.setNom(pRS.getString("nom"));
        pays.setCodeAlpha2(pRS.getString("code_alpha_2"));
        pays.setCodeAlpha3(pRS.getString("code_alpha_3"));

        return pays;
    }
}
