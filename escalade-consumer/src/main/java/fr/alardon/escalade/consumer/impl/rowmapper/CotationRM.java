package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class CotationRM implements RowMapper<Cotation> {

    @Override
    public Cotation mapRow (ResultSet pRS, int pRowNum) throws SQLException {
        Cotation cotation = new Cotation(pRS.getString("cotation"));
        cotation.setDescription(pRS.getString("description"));


        return cotation;
    }

}
