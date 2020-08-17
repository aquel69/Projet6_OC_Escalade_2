package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireSiteEscalade;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireTopo;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;

import java.util.List;

public interface ListeCommentaireDao {

    /**
     *
     * @param idSite
     * @return la liste de tous les commentaire par site
     */
    public List<ListeCommentaireSiteEscalade> readListeCommentaire(int idSite);

    /**
     *
     * @param pCommentaire
     * @param pSiteEscalade
     * @return ajoute un commentaire dans la liste des sites d'escalade
     */
    public Integer ajouterUnCommentaireALaListe(Commentaire pCommentaire, SiteEscalade pSiteEscalade);

    /**
     *
     * @param idTopo
     * @param idUtilisateurReservant
     * @return la liste des commentaires par topo
     */
    public List<ListeCommentaireTopo> readListeCommentaireTopo(int idTopo, int idUtilisateurReservant);

    /**
     *
     * @param pCommentaire
     * @param idTopo
     * @param utilisateur
     * @return ajoute un commentaire dans la liste des topos
     */
     public Integer ajouterUnCommentaireALaListeTopo(Commentaire pCommentaire, int pIdTopo, int pIdReservant);

}
