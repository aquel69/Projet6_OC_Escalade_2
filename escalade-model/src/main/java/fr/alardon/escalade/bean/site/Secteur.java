package fr.alardon.escalade.bean.site;

public class Secteur {

    // ==================== Attributs ====================
    private int idSecteur;
    private String nom;
    private SiteEscalade site;

    // ================== Constructeurs ==================
    public Secteur(int idSecteur, String nom, SiteEscalade site) {
        this.idSecteur = idSecteur;
        this.nom = nom;
        this.site = site;
    }

    public Secteur(int id_secteur) {this.idSecteur = id_secteur;}

    public Secteur() {

    }


    // ================= Getters/Setters =================
    public int getIdSecteur() {return idSecteur;}
    public void setIdSecteur(int idSecteur) {this.idSecteur = idSecteur;}
    public SiteEscalade getSite() {return site;}
    public void setSite(SiteEscalade site) {this.site = site;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "Secteur{" +
                "idSecteur=" + idSecteur +
                ", nom='" + nom + '\'' +
                ", site=" + site +
                '}';
    }
}
