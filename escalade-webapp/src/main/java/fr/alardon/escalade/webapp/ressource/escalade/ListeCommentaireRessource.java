package fr.alardon.escalade.webapp.ressource.escalade;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireSiteEscalade;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireTopo;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class ListeCommentaireRessource extends AbstractRessource {

    public List<ListeCommentaireSiteEscalade> readListeCommentaire(int idSite){return getManagerFactory().getListeCommentaireManager().readListeCommentaire(idSite);}

    public Integer ajouterUnCommentaireALaListe(Commentaire pCommentaire, SiteEscalade pSiteEscalade){return getManagerFactory().getListeCommentaireManager().ajouterUnCommentaireALaListe(pCommentaire, pSiteEscalade);}

    public List<ListeCommentaireTopo> readListeCommentaireTopo(int idTopo, int idUtilisateurReservant){return getManagerFactory().getListeCommentaireManager().readListeCommentaireTopo(idTopo, idUtilisateurReservant);}

    public Integer ajouterUnCommentaireALaListeTopo(Commentaire pCommentaire, int idTopo, int idReservant){return getManagerFactory().getListeCommentaireManager().ajouterUnCommentaireALaListeTopo(pCommentaire,idTopo, idReservant);}
}
