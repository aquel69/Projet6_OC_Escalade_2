package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireSiteEscalade;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireTopo;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.business.contract.manager.ListeCommentaireManager;

import javax.inject.Named;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Named
public class ListeCommentaireManagerImpl extends AbstractManager implements ListeCommentaireManager {

    @Override
    public List<ListeCommentaireSiteEscalade> readListeCommentaire(int idSite) {
        List<ListeCommentaireSiteEscalade> listeCommentaireSiteEscaladeList = getDaoFactory().getListeCommentaireDao().readListeCommentaire(idSite);
        for (ListeCommentaireSiteEscalade liste : listeCommentaireSiteEscaladeList) {
            LocalDateTime tempsCourant = LocalDateTime.now();
            LocalDateTime tempsCommentaire = liste.getCommentaire().getDate();
            Period p = Period.between(tempsCommentaire.toLocalDate(), tempsCourant.toLocalDate());
            int periodeEnJour = p.getDays();
            liste.getCommentaire().setPeriode(periodeEnJour);
        }

        return listeCommentaireSiteEscaladeList;
    }

    @Override
    public List<ListeCommentaireTopo> readListeCommentaireTopo(int idTopo, int idUtilisateurReservant){
        List<ListeCommentaireTopo> listeCommentaireTopos = getDaoFactory().getListeCommentaireDao().readListeCommentaireTopo(idTopo, idUtilisateurReservant);
        for(ListeCommentaireTopo liste : listeCommentaireTopos){
            LocalDateTime tempsCourant = LocalDateTime.now();
            LocalDateTime tempsCommentaire = liste.getCommentaire().getDate();
            Period p = Period.between(tempsCommentaire.toLocalDate(), tempsCourant.toLocalDate());
            int periodeEnJour = p.getDays();
            liste.getCommentaire().setPeriode(periodeEnJour);
        }

        return listeCommentaireTopos;
    }

    @Override
    public Integer ajouterUnCommentaireALaListe(Commentaire pCommentaire, SiteEscalade pSiteEscalade){return getDaoFactory().getListeCommentaireDao().ajouterUnCommentaireALaListe(pCommentaire, pSiteEscalade);}

    @Override
    public Integer ajouterUnCommentaireALaListeTopo(Commentaire pCommentaire, int idTopo, int idReservant){return getDaoFactory().getListeCommentaireDao().ajouterUnCommentaireALaListeTopo(pCommentaire,idTopo, idReservant);}

}
