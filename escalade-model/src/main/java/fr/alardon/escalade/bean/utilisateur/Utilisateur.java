package fr.alardon.escalade.bean.utilisateur;

import fr.alardon.escalade.bean.adresse.Adresse;
import fr.alardon.escalade.bean.referentiel.EnumRole;

import javax.rmi.CORBA.Util;


public class Utilisateur {


    // ==================== Attributs ====================
    private boolean connecte = false;
    private int idUtilisateur;
    private String nomUtilisateur;
    private String motDePasse;
    private String email;
    private String nom;
    private String prenom;
    private Adresse adresse;
    private EnumRole role;

    // ================== Constructeurs ==================


    public Utilisateur(boolean connecte, int idUtilisateur, String nomUtilisateur, String motDePasse, String email, String nom, String prenom, Adresse adresse, EnumRole role) {
        this.connecte = connecte;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;

        this.role = role;
    }

    public Utilisateur(int id_utilisateur) {
        this.idUtilisateur = id_utilisateur;
    }

    public Utilisateur() {

    }

    // ================= Getters/Setters =================
    public int getIdUtilisateur() {return idUtilisateur;}
    public void setIdUtilisateur(int idUtilisateur) {this.idUtilisateur = idUtilisateur;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public String getNomUtilisateur() {return nomUtilisateur;}
    public void setNomUtilisateur(String nomUtilisateur) {this.nomUtilisateur = nomUtilisateur;}
    public String getMotDePasse() {return motDePasse;}
    public void setMotDePasse(String motDePasse) {this.motDePasse = motDePasse;}
    public Adresse getAdresse() {return adresse;}
    public void setAdresse(Adresse adresse) {this.adresse = adresse;}
    public EnumRole getRole() {return role;}
    public void setRole(EnumRole role) {this.role = role;}
    public boolean isConnecte() {return connecte;}
    public void setConnecte(boolean connecte) {this.connecte = connecte;}


    // ===================== Méthodes =====================


    @Override
    public String toString() {
        return "Utilisateur{" +
                "connecte=" + connecte +
                ", idUtilisateur=" + idUtilisateur +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse=" + adresse +
                ", role=" + role +
                '}';
    }
}
