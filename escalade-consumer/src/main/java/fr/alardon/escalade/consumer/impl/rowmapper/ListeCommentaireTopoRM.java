package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireTopo;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.CommentaireDao;
import fr.alardon.escalade.consumer.contract.dao.TopoDao;
import fr.alardon.escalade.consumer.contract.dao.UtilisateurDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class ListeCommentaireTopoRM implements RowMapper<ListeCommentaireTopo> {

    @Inject
    CommentaireDao commentaireDaoImpl;

    @Inject
    TopoDao topoDaoImpl;

    @Inject
    UtilisateurDao utilisateurDaoImpl;

    public ListeCommentaireTopo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        ListeCommentaireTopo listeCommentaire = new ListeCommentaireTopo(pRS.getInt("id_commentaire_topo"));

        Commentaire vCommentaire = commentaireDaoImpl.read(pRS.getInt("id_commentaire"));
        listeCommentaire.setCommentaire(vCommentaire);

        Topo vTopo = topoDaoImpl.read(pRS.getInt("id_topo"));
        listeCommentaire.setTopo(vTopo);

        Utilisateur vUtilisateur = utilisateurDaoImpl.readSansMotDePasse(pRS.getInt("id_utilisateur_reservant"));
        listeCommentaire.setUtilisateur(vUtilisateur);

        return listeCommentaire;
    }

}
