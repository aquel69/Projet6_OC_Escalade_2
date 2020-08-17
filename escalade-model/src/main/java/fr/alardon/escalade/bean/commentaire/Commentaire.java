package fr.alardon.escalade.bean.commentaire;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;

import java.time.LocalDateTime;
import java.time.Period;

public class Commentaire {

    // ==================== Attributs ====================
    private int idCommentaire;
    private String commentaire;
    private Utilisateur utilisateur;
    private LocalDateTime date;
    private int periode;

// ================== Constructeurs ==================
    public Commentaire(int idCommentaire, String commentaire, Utilisateur utilisateur, LocalDateTime date, int periode) {
        this.idCommentaire = idCommentaire;
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
        this.date = date;
        this.periode = periode;
    }

    public Commentaire(int id_commentaire) {this.idCommentaire = id_commentaire;}

    public Commentaire() {

    }

    // ================= Getters/Setters =================
    public int getIdCommentaire() {return idCommentaire;}
    public void setIdCommentaire(int idCommentaire) {this.idCommentaire = idCommentaire;}
    public String getCommentaire() {return commentaire;}
    public void setCommentaire(String commentaire) {this.commentaire = commentaire;}
    public Utilisateur getUtilisateur() {return utilisateur;}
    public void setUtilisateur(Utilisateur utilisateur) {this.utilisateur = utilisateur;}
    public LocalDateTime getDate() {return date;}
    public void setDate(LocalDateTime date) {this.date = date;}
    public int getPeriode() {return periode;}

    public void setPeriode(int periode) {this.periode = periode;}



    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "Commentaire{" +
                "idCommentaire=" + idCommentaire +
                ", commentaire='" + commentaire + '\'' +
                ", utilisateur=" + utilisateur +
                ", date=" + date +
                ", periode=" + periode +
                '}';
    }
}
