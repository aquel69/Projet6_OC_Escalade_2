package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.commentaire.Commentaire;

import java.util.List;

public interface CommentaireDao {

    /**
     *
     * @return la liste de tous les commentaire
     */
    public List<Commentaire> readCommentaire(int idSite);

    /**
     *
     * @param idCommentaire
     * @return la liste d'un commentaire
     */
    public Commentaire read(int idCommentaire);

    /**
     *
     * @param pCommentaire
     * @return ajoute un commentaire
     */
    public Integer ajouterUnCommentaire(Commentaire pCommentaire);

    /**
     *
     * @return l'id du dernier commentaire
     */
    public int idDernierCommentaire();

}
