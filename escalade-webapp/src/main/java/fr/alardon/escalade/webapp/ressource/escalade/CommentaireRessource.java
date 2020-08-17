package fr.alardon.escalade.webapp.ressource.escalade;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class CommentaireRessource extends AbstractRessource {

    public List<Commentaire> readCommentaire(int idSite){return getManagerFactory().getCommentaireManager().readCommentaire(idSite);}

    public Commentaire read(int idCommentaire){return getManagerFactory().getCommentaireManager().read(idCommentaire);}

    public Integer ajouterUnCommentaire(Commentaire pCommentaire){return getManagerFactory().getCommentaireManager().ajouterUnCommentaire(pCommentaire);}

    public int idDernierCommentaire(){return getManagerFactory().getCommentaireManager().idDernierCommentaire();}

}
