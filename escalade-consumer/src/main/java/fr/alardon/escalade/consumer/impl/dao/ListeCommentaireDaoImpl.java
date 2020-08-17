package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireSiteEscalade;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireTopo;
import fr.alardon.escalade.bean.photo.ListePhotoSite;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.ListeCommentaireDao;
import fr.alardon.escalade.consumer.impl.rowmapper.ListeCommentaireRM;
import fr.alardon.escalade.consumer.impl.rowmapper.ListeCommentaireTopoRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ListeCommentaireDaoImpl extends AbstractDao implements ListeCommentaireDao {

    @Inject
    ListeCommentaireRM listeCommentaireRM;

    @Inject
    ListeCommentaireTopoRM listeCommentaireTopoRM;

    @Override
    public List<ListeCommentaireSiteEscalade> readListeCommentaire(int idSite) {
        String vSQL = "SELECT * FROM liste_commentaire_site_escalade as lis\n" +
                "INNER JOIN commentaire com\n" +
                "ON lis.commentaire = com.id_commentaire\n" +
                "INNER JOIN site_escalade sit\n" +
                "ON lis.site_escalade = sit.id_site\n" +
                "INNER JOIN utilisateur uti\n" +
                "ON com.utilisateur = uti.id_utilisateur\n" +
                "WHERE sit.id_site =" + idSite +" ORDER BY lis.id_liste_commentaire DESC";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<ListeCommentaireSiteEscalade> vListCommentaire = vJdbcTemplate.query(vSQL, listeCommentaireRM);

        return vListCommentaire;
    }

    @Override
    public Integer ajouterUnCommentaireALaListe(Commentaire pCommentaire, SiteEscalade pSiteEscalade) {
        String vSQL = "INSERT INTO liste_commentaire_site_escalade (commentaire, site_escalade) VALUES (:commentaire, :site_escalade) ";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("commentaire", pCommentaire.getIdCommentaire());
        vParams.addValue("site_escalade", pSiteEscalade.getIdSite());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public Integer ajouterUnCommentaireALaListeTopo(Commentaire pCommentaire, int pIdTopo, int pIdReservant) {
        String vSQL = "INSERT INTO liste_commentaire_topo (id_commentaire, id_topo, id_utilisateur_reservant) VALUES (:idCommentaire, :idTopo, :idUtilisateur) ";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("idCommentaire", pCommentaire.getIdCommentaire());
        vParams.addValue("idTopo", pIdTopo);
        vParams.addValue("idUtilisateur", pIdReservant);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public List<ListeCommentaireTopo> readListeCommentaireTopo(int idTopo, int idUtilisateurReservant) {
        String vSQL = " SELECT * FROM liste_commentaire_topo AS lis, commentaire AS com\n" +
                "    WHERE lis.id_commentaire = com.id_commentaire\n" +
                "    GROUP BY  lis.id_topo, com.utilisateur, lis.id_commentaire_topo, com.id_commentaire\n" +
                "    HAVING id_topo =" + idTopo + " AND id_utilisateur_reservant =" + idUtilisateurReservant + " ORDER BY com.id_commentaire DESC";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<ListeCommentaireTopo> vListCommentaireTopo = vJdbcTemplate.query(vSQL, listeCommentaireTopoRM);

        return vListCommentaireTopo;
    }

}
