package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireSiteEscalade;

import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.consumer.contract.dao.CommentaireDao;

import fr.alardon.escalade.consumer.contract.dao.SiteDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class ListeCommentaireRM implements RowMapper<ListeCommentaireSiteEscalade> {

    @Inject
    SiteDao siteDaoImpl;

    @Inject
    CommentaireDao commentaireDaoImpl;

    public ListeCommentaireSiteEscalade mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        ListeCommentaireSiteEscalade listeCommentaire = new ListeCommentaireSiteEscalade(pRS.getInt("id_liste_commentaire"));

        SiteEscalade vSiteEscalade = siteDaoImpl.read(pRS.getInt("site_escalade"));
        listeCommentaire.setSiteEscalade(vSiteEscalade);

        Commentaire vCommentaire = commentaireDaoImpl.read(pRS.getInt("commentaire"));
        listeCommentaire.setCommentaire(vCommentaire);

        return listeCommentaire;
    }

}
