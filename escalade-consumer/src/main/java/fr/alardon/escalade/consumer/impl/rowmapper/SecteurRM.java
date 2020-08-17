package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.consumer.contract.dao.SiteDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class SecteurRM implements RowMapper<Secteur> {
    @Inject
    SiteDao siteDaoImpl;

    @Override
    public Secteur mapRow(ResultSet pRs, int rowNum) throws SQLException {
        Secteur secteur = new Secteur(pRs.getInt("id_secteur"));
        secteur.setNom(pRs.getString("nom"));

        SiteEscalade vSite = siteDaoImpl.read(pRs.getInt("id_site"));
        secteur.setSite(vSite);

        return secteur;
    }
}
