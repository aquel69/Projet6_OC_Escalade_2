package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.Voie;
import fr.alardon.escalade.consumer.contract.dao.SecteurDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class VoieRM implements RowMapper<Voie> {

    @Inject
    SecteurDao SecteurDaoImpl;

    @Override
    public Voie mapRow(ResultSet pRs, int rowNum) throws SQLException {
        Voie voie = new Voie(pRs.getInt("id_voie"));
        voie.setNom(pRs.getString("nom"));
        voie.setNumeroDeVoie(pRs.getString("numero_de_voie"));
        voie.setCotation(pRs.getString("cotation"));

        Secteur vSecteur = SecteurDaoImpl.read(pRs.getInt("id_secteur"));
        voie.setSecteur(vSecteur);

        return voie;
    }

}
