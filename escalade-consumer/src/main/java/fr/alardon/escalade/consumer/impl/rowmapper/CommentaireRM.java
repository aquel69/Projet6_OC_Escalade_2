package fr.alardon.escalade.consumer.impl.rowmapper;


import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireSiteEscalade;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.UtilisateurDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class CommentaireRM implements RowMapper<Commentaire> {

    @Inject
    UtilisateurDao utilisateurDaoImpl;

    @Override
    public Commentaire mapRow (ResultSet pRS, int pRowNum) throws SQLException {
        Commentaire commentaire = new Commentaire(pRS.getInt("id_commentaire"));
        commentaire.setCommentaire(pRS.getString("commentaire"));
        commentaire.setDate(pRS.getTimestamp("date").toLocalDateTime());

        Utilisateur vUtilisateur = utilisateurDaoImpl.readSansMotDePasse(pRS.getInt("utilisateur"));
        commentaire.setUtilisateur(vUtilisateur);

        return commentaire;
    }

}
