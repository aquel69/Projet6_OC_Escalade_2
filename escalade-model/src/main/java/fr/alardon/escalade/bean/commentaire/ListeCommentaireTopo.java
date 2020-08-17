package fr.alardon.escalade.bean.commentaire;

import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;

public class ListeCommentaireTopo {

    // ==================== Attributs ====================
    private int idListeCommentaireTopo;
    private Commentaire commentaire;
    private Topo topo;
    private Utilisateur utilisateur;

    // ================== Constructeurs ==================
    public ListeCommentaireTopo(int idListeCommentaireTopo, Commentaire commentaire, Topo topo, Utilisateur utilisateur) {
        this.idListeCommentaireTopo = idListeCommentaireTopo;
        this.commentaire = commentaire;
        this.topo = topo;
        this.utilisateur = utilisateur;
    }

    public ListeCommentaireTopo(int id_commentaire_topo) {this.idListeCommentaireTopo = id_commentaire_topo;}

    // ================= Getters/Setters =================
    public int getIdListeCommentaireTopo() {return idListeCommentaireTopo;}
    public void setIdListeCommentaireTopo(int idListeCommentaireTopo) {this.idListeCommentaireTopo = idListeCommentaireTopo;}
    public Commentaire getCommentaire() {return commentaire;}
    public void setCommentaire(Commentaire commentaire) {this.commentaire = commentaire;}
    public Topo getTopo() {return topo;}
    public void setTopo(Topo topo) {this.topo = topo;}
    public Utilisateur getUtilisateur() {return utilisateur;}
    public void setUtilisateur(Utilisateur utilisateur) {this.utilisateur = utilisateur;}

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "ListeCommentaireTopo{" +
                "idListeCommentaireTopo=" + idListeCommentaireTopo +
                ", commentaire=" + commentaire +
                ", topo=" + topo +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
