package fr.alardon.escalade.bean.site;



public class Voie {

    // ==================== Attributs ====================
    private int idVoie;
    private String numeroDeVoie;
    private String nom;
    private String cotation;
    private Secteur secteur;


    // ================== Constructeurs ==================
    public Voie(int idVoie, String numeroDeVoie, String nom, String cotation, Secteur secteur) {
        this.idVoie = idVoie;
        this.numeroDeVoie = numeroDeVoie;
        this.nom = nom;
        this.cotation = cotation;
        this.secteur = secteur;
    }

    public Voie(int id_voie) {
    }

    public Voie() {

    }

    // ================= Getters/Setters =================
    public int getIdVoie() {return idVoie;}
    public void setIdVoie(int idVoie) {this.idVoie = idVoie;}
    public String getNumeroDeVoie() {return numeroDeVoie;}
    public void setNumeroDeVoie(String numeroDeVoie) {
        this.numeroDeVoie = numeroDeVoie;}
    public Secteur getSecteur() {return secteur;}
    public void setSecteur(Secteur secteur) {this.secteur = secteur;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getCotation() {return cotation;}
    public void setCotation(String cotation) {this.cotation = cotation;}


    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "Voie{" +
                "idVoie=" + idVoie +
                ", NumeroDeVoie='" + numeroDeVoie + '\'' +
                ", nom='" + nom + '\'' +
                ", cotation='" + cotation + '\'' +
                ", secteur=" + secteur +
                '}';
    }
}
