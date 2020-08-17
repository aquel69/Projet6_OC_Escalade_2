package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.adresse.Adresse;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.consumer.contract.dao.*;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class SiteRM implements RowMapper<SiteEscalade> {
    @Inject
    AdresseDao adresseDaoImpl;

    @Inject
    OrientationDao orientationDaoImpl;

    @Override
    public SiteEscalade mapRow (ResultSet pRS, int pRowNum) throws SQLException {
        SiteEscalade site = new SiteEscalade(pRS.getInt("id_site"));
        site.setNom(pRS.getString("nom"));
        site.setAltitude(pRS.getString("altitude"));
        site.setHauteur(pRS.getString("hauteur"));
        site.setTaguer(pRS.getBoolean("taguer"));
        site.setTempsApproche(pRS.getString("temps_d_approche"));
        site.setTypeDeRoche(pRS.getString("type_de_roche"));

        Adresse vAdresse = adresseDaoImpl.read(pRS.getInt("adresse"));
        site.setAdresse(vAdresse);

        Orientation vOrientation = orientationDaoImpl.read(pRS.getString("orientation"));
        site.setOrientation(vOrientation);

        return site;
    }
}
