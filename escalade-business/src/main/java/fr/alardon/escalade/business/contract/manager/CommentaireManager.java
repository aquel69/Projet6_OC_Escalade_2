package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.commentaire.Commentaire;

import java.util.List;

public interface CommentaireManager {
    public List<Commentaire> readCommentaire(int idSite);

    public Commentaire read(int idCommentaire);

    public Integer ajouterUnCommentaire(Commentaire pCommentaire);

    public int idDernierCommentaire();
}
