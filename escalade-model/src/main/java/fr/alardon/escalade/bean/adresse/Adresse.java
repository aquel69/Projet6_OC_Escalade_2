package fr.alardon.escalade.bean.adresse;

import fr.alardon.escalade.bean.referentiel.Departement;
import fr.alardon.escalade.bean.referentiel.Pays;
import fr.alardon.escalade.bean.referentiel.Region;

public class Adresse {

    // ==================== Attributs ====================
    private int idAdresse;
    private String adresse;
    private String ville;
    private String codePostal;
    private Pays pays;
    private Region region;
    private Departement departement;


    // ================== Constructeurs ==================
    public Adresse(int idAdresse, String adresse, String ville, String codePostal, Pays pays, Region region, Departement departement) {
        this.idAdresse = idAdresse;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.pays = pays;
        this.region = region;
        this.departement = departement;
    }

    public Adresse(int idadresse) {this.idAdresse = idadresse;}

    public Adresse() {

    }

    // ================= Getters/Setters =================
    public int getIdAdresse() {return idAdresse;}
    public void setIdAdresse(int idAdresse) {this.idAdresse = idAdresse;}
    public String getAdresse() {return adresse;}
    public void setAdresse(String adresse) {this.adresse = adresse;}
    public String getVille() {return ville;}
    public void setVille(String ville) {this.ville = ville;}
    public String getCodePostal() {return codePostal;}
    public void setCodePostal(String codePostal) {this.codePostal = codePostal;}
    public Pays getPays() {return pays;}
    public void setPays(Pays pays) {this.pays = pays;}
    public Region getRegion() {return region;}
    public void setRegion(Region region) {this.region = region;}
    public Departement getDepartement() {return departement;}
    public void setDepartement(Departement departement) {this.departement = departement;}

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "Adresse{" +
                "idAdresse=" + idAdresse +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", pays=" + pays +
                ", region=" + region +
                ", departement=" + departement +
                '}';
    }
}
