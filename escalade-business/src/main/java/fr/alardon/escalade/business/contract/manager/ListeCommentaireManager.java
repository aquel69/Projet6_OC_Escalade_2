package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireSiteEscalade;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireTopo;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;

import java.util.List;

public interface ListeCommentaireManager {

    public List<ListeCommentaireSiteEscalade> readListeCommentaire(int idSite);

    public Integer ajouterUnCommentaireALaListe(Commentaire pCommentaire, SiteEscalade pSiteEscalade);

    public List<ListeCommentaireTopo> readListeCommentaireTopo(int idTopo, int idUtilisateurReservant);

    public Integer ajouterUnCommentaireALaListeTopo(Commentaire pCommentaire, int idTopo, int pIdReservant);

}
