package fr.alardon.escalade.bean.topo;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;

import java.time.LocalDateTime;

public class Topo {

    // ==================== Attributs ====================
    private int idTopo;
    private String nom;
    private String description;
    private String lieu;
    private LocalDateTime dateDeParution;
    private LocalDateTime dateDeReservation;
    private boolean disponibilite;
    private boolean demandeReservation;
    private int periode;
    private Utilisateur reservant;
    private Utilisateur utilisateur;

    // ================== Constructeurs ==================
    public Topo(int idTopo, String nom, String description, String lieu, LocalDateTime dateDeParution, LocalDateTime dateDeReservation, boolean disponibilite, boolean demandeReservation, int periode, Utilisateur reservant, Utilisateur utilisateur) {
        this.idTopo = idTopo;
        this.nom = nom;
        this.description = description;
        this.lieu = lieu;
        this.dateDeParution = dateDeParution;
        this.dateDeReservation = dateDeReservation;
        this.disponibilite = disponibilite;
        this.demandeReservation = demandeReservation;
        this.periode = periode;
        this.reservant = reservant;
        this.utilisateur = utilisateur;
    }

    public Topo(int id_topo) {this.idTopo = id_topo;}

    public Topo() {

    }

    // ================= Getters/Setters =================
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getLieu() {return lieu;}
    public void setLieu(String lieu) {this.lieu = lieu;}
    public LocalDateTime getDateDeParution() {return dateDeParution;}
    public void setDateDeParution(LocalDateTime dateDeParution) {this.dateDeParution = dateDeParution;}
    public boolean isDisponibilite() {return disponibilite;}
    public void setDisponibilite(boolean disponibilite) {this.disponibilite = disponibilite;}
    public int getIdTopo() {return idTopo;}
    public void setIdTopo(int idTopo) {this.idTopo = idTopo;}
    public Utilisateur getUtilisateur() {return utilisateur;}
    public void setUtilisateur(Utilisateur utilisateur) {this.utilisateur = utilisateur;}
    public boolean isDemandeReservation() {return demandeReservation;}
    public void setDemandeReservation(boolean demandeReservation) {this.demandeReservation = demandeReservation;}
    public int getPeriode() {return periode;}
    public void setPeriode(int periode) {this.periode = periode;}
    public LocalDateTime getDateDeReservation() {return dateDeReservation;}
    public void setDateDeReservation(LocalDateTime dateDeReservation) {this.dateDeReservation = dateDeReservation;}
    public Utilisateur getReservant() {return reservant;}
    public void setReservant(Utilisateur reservant) {this.reservant = reservant;}

    // ================= Getters/Setters =================
    @Override
    public String toString() {
        return "Topo{" +
                "idTopo=" + idTopo +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", lieu='" + lieu + '\'' +
                ", dateDeParution=" + dateDeParution +
                ", dateDeReservation=" + dateDeReservation +
                ", disponibilite=" + disponibilite +
                ", demandeReservation=" + demandeReservation +
                ", periode=" + periode +
                ", reservant=" + reservant +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
