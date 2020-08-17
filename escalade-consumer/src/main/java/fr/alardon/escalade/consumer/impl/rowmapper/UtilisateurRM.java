package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.adresse.Adresse;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.AdresseDao;

import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class UtilisateurRM implements RowMapper<Utilisateur> {
    @Inject
    AdresseDao adresseDaoImpl;

    @Override
    public Utilisateur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        Utilisateur utilisateur = new Utilisateur(pRS.getInt("id_utilisateur"));
        utilisateur.setMotDePasse(pRS.getString("mot_de_passe"));
        utilisateur.setEmail(pRS.getString("email"));
        utilisateur.setNom(pRS.getString("nom"));
        utilisateur.setPrenom(pRS.getString("prenom"));
        utilisateur.setNomUtilisateur(pRS.getString("nom_utilisateur"));

        Adresse adresse = adresseDaoImpl.read(pRS.getInt("id_adresse"));
        utilisateur.setAdresse(adresse);

        return utilisateur;
    }
}
