package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.referentiel.Departement;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.CommentaireDao;
import fr.alardon.escalade.consumer.impl.rowmapper.CommentaireRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireDaoImpl extends AbstractDao implements CommentaireDao {

    @Inject
    CommentaireRM commentaireRM;

    @Override
    public Commentaire read(int idCommentaire){
        String vSQL = "SELECT * FROM commentaire WHERE id_commentaire =" + idCommentaire;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSQL, commentaireRM);
        Commentaire commentaire = vListCommentaire.get(0);

        return commentaire;

    }

    @Override
    public List<Commentaire> readCommentaire(int idSite) {
        String vSQL = "SELECT com.id_commentaire, com.commentaire, date, uti.id_utilisateur, uti.nom_utilisateur, lis.site_escalade FROM commentaire as com\n" +
                "INNER JOIN utilisateur as uti\n" +
                "ON com.utilisateur = uti.id_utilisateur\n" +
                "INNER JOIN liste_commentaire_site_escalade as lis\n" +
                "ON com.id_commentaire = lis.commentaire\n" +
                "WHERE lis.site_escalade =" + idSite;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSQL, commentaireRM);

        return vListCommentaire;
    }

    @Override
    public Integer ajouterUnCommentaire(Commentaire pCommentaire) {
        String vSQL = "INSERT INTO commentaire (commentaire, date,utilisateur) VALUES (:commentaire, :date, :idUtilisateur) ";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("commentaire", pCommentaire.getCommentaire());
        vParams.addValue("date", pCommentaire.getDate());
        vParams.addValue("idUtilisateur", pCommentaire.getUtilisateur().getIdUtilisateur());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }



    @Override
    public int idDernierCommentaire(){

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT currval(pg_get_serial_sequence('commentaire', 'id_commentaire'))";
        int id = vJdbcTemplate.queryForObject(vSQL, Integer.class);

        return id;
    }

}
