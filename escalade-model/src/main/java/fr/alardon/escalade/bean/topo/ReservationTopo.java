package fr.alardon.escalade.bean.topo;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;

import java.time.LocalDateTime;


public class ReservationTopo {

    // ==================== Attributs ====================
    private int idReservationTopo;
    private Topo topo;
    private boolean demandeDeReservation;
    private LocalDateTime dateDeReservation;
    private Utilisateur utilisateurReservant;

    // ================== Constructeurs ==================
    public ReservationTopo(int idReservationTopo, Topo topo, boolean demandeDeReservation, LocalDateTime dateDeReservation, Utilisateur utilisateurReservant) {
        this.idReservationTopo = idReservationTopo;
        this.topo = topo;
        this.demandeDeReservation = demandeDeReservation;
        this.dateDeReservation = dateDeReservation;
        this.utilisateurReservant = utilisateurReservant;
    }

    // ================= Getters/Setters =================
    public int getIdReservationTopo() {return idReservationTopo;}
    public void setIdReservationTopo(int idReservationTopo) {this.idReservationTopo = idReservationTopo;}
    public Topo getTopo() {return topo;}
    public void setTopo(Topo topo) {this.topo = topo;}
    public boolean isDemandeDeReservation() {return demandeDeReservation;}
    public void setDemandeDeReservation(boolean demandeDeReservation) {this.demandeDeReservation = demandeDeReservation;}
    public LocalDateTime getDateDeReservation() {return dateDeReservation;}
    public void setDateDeReservation(LocalDateTime dateDeReservation) {this.dateDeReservation = dateDeReservation;}
    public Utilisateur getUtilisateurReservant() {return utilisateurReservant;}
    public void setUtilisateurReservant(Utilisateur utilisateurReservant) {this.utilisateurReservant = utilisateurReservant;}

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "ReservationTopo{" +
                "id=" + idReservationTopo +
                ", topo=" + topo +
                ", demandeDeReservation=" + demandeDeReservation +
                ", dateDeReservation=" + dateDeReservation +
                ", utilisateurReservant=" + utilisateurReservant +
                '}';
    }
}
