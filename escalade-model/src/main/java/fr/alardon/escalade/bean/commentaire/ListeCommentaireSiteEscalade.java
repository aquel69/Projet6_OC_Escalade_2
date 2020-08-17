package fr.alardon.escalade.bean.commentaire;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.site.SiteEscalade;

public class ListeCommentaireSiteEscalade {

    // ==================== Attributs ====================
    private int idListeCommentaire;
    private Commentaire commentaire;
    private SiteEscalade siteEscalade;

    // ================== Constructeurs ==================
    public ListeCommentaireSiteEscalade(int idListeCommentaire, Commentaire commentaire, SiteEscalade siteEscalade) {
        this.idListeCommentaire = idListeCommentaire;
        this.commentaire = commentaire;
        this.siteEscalade = siteEscalade;
    }

    public ListeCommentaireSiteEscalade(int id_liste_photo) {this.idListeCommentaire = id_liste_photo;}

    // ================= Getters/Setters =================
    public int getIdListeCommentaire() {return idListeCommentaire;}
    public void setIdListeCommentaire(int idListeCommentaire) {this.idListeCommentaire = idListeCommentaire;}
    public Commentaire getCommentaire() {return commentaire;}
    public void setCommentaire(Commentaire commentaire) {this.commentaire = commentaire;}
    public SiteEscalade getSiteEscalade() {return siteEscalade;}
    public void setSiteEscalade(SiteEscalade siteEscalade) {this.siteEscalade = siteEscalade;}

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "ListeCommentaireSiteEscalade{" +
                "id=" + idListeCommentaire +
                ", commentaire=" + commentaire +
                ", siteEscalade=" + siteEscalade +
                '}';
    }
}
