package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.business.contract.manager.CommentaireManager;

import javax.inject.Named;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

    @Override
    public List<Commentaire> readCommentaire(int idSite){return getDaoFactory().getCommentaireDao().readCommentaire(idSite);}

    @Override
    public Commentaire read(int idCommentaire){return getDaoFactory().getCommentaireDao().read(idCommentaire);}

    @Override
    public Integer ajouterUnCommentaire(Commentaire pCommentaire){return getDaoFactory().getCommentaireDao().ajouterUnCommentaire(pCommentaire);}

    @Override
    public int idDernierCommentaire(){return getDaoFactory().getCommentaireDao().idDernierCommentaire();}


}
