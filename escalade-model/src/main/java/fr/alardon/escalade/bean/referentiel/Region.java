package fr.alardon.escalade.bean.referentiel;

public class Region {

    // ==================== Attributs ====================
    private Integer idRegion;
    private String nom;
    private Pays pays;

    // ================== Constructeurs ==================
    public Region(Integer idRegion, String nom, Pays pays) {
        this.idRegion = idRegion;
        this.nom = nom;
        this.pays = pays;
    }

    public Region(int id_region) {this.idRegion = id_region;}

    public Region() {

    }

    // ================= Getters/Setters =================
    public Integer getIdRegion() {
        return idRegion;
    }
    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Pays getPays() {
        return pays;
    }
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "Region{" +
                "id=" + idRegion +
                ", nom='" + nom + '\'' +
                ", pays=" + pays +
                '}';
    }
}
