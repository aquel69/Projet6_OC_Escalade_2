package fr.alardon.escalade.bean.referentiel;

public class Departement {

    // ==================== Attributs ====================
    private Integer idDepartement;
    private String numero;
    private String nom;
    private Region region;

    // ================== Constructeurs ==================
    public Departement(Integer idDepartement, String numero, String nom, Region region) {
        this.idDepartement = idDepartement;
        this.numero = numero;
        this.nom = nom;
        this.region = region;
    }

    public Departement(int idDepartement) {this.idDepartement = idDepartement;}

    public Departement() {

    }

    // ================= Getters/Setters =================
    public Integer getIdDepartement() {
        return idDepartement;
    }
    public void setIdDepartement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Region getRegion() {
        return region;
    }
    public void setRegion(Region region) {
        this.region = region;
    }

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "Departement{" +
                "id=" + idDepartement +
                ", numero='" + numero + '\'' +
                ", nom='" + nom + '\'' +
                ", region=" + region +
                '}';
    }
}
