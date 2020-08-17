package fr.alardon.escalade.bean.site;

import fr.alardon.escalade.bean.adresse.Adresse;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.referentiel.Orientation;

import java.util.List;


public class SiteEscalade {

    // ==================== Attributs ====================
    private int idSite;
    private String nom;
    private String typeDeRoche;
    private String hauteur;
    private String altitude;
    private String tempsApproche;
    private boolean taguer;
    private int nombreDeVoie;
    private int nombreDeSecteur;
    private String cotationMin;
    private String cotationMax;
    private List<UrlPhoto> listeDesPhotos;
    private Orientation orientation;
    private Adresse adresse;
    private Secteur secteur;


    // ================== Constructeurs ==================
    public SiteEscalade(int idSite, String nom, String typeDeRoche, String hauteur, String altitude, String tempsApproche, boolean taguer, int nombreDeVoie, int nombreDeSecteur, String cotationMin, String cotationMax, List<UrlPhoto> listeDesPhotos, Orientation orientation, Adresse adresse, Secteur secteur) {
        this.idSite = idSite;
        this.nom = nom;
        this.typeDeRoche = typeDeRoche;
        this.hauteur = hauteur;
        this.altitude = altitude;
        this.tempsApproche = tempsApproche;
        this.taguer = taguer;
        this.nombreDeVoie = nombreDeVoie;
        this.nombreDeSecteur = nombreDeSecteur;
        this.cotationMin = cotationMin;
        this.cotationMax = cotationMax;
        this.listeDesPhotos = listeDesPhotos;
        this.orientation = orientation;
        this.adresse = adresse;
        this.secteur = secteur;
    }

    public SiteEscalade(int idSite) {this.idSite = idSite;}

    public SiteEscalade() {}

    // ================= Getters/Setters =================
    public int getIdSite() {return idSite;}
    public void setIdSite(int idSite) {this.idSite = idSite;}
    public Orientation getOrientation() {return orientation;}
    public void setOrientation(Orientation orientation) {this.orientation = orientation;}
    public String getHauteur() {return hauteur;}
    public void setHauteur(String hauteur) {this.hauteur = hauteur;}
    public boolean isTaguer() {return taguer;}
    public void setTaguer(boolean taguer) {this.taguer = taguer;}
    public String getTypeDeRoche() {return typeDeRoche;}
    public void setTypeDeRoche(String typeDeRoche) {this.typeDeRoche = typeDeRoche;}
    public String getAltitude() {return altitude;}
    public void setAltitude(String altitude) {this.altitude = altitude;}
    public String getTempsApproche() {return tempsApproche;}
    public void setTempsApproche(String tempsApproche) {this.tempsApproche = tempsApproche;}
    public Adresse getAdresse() {return adresse;}
    public void setAdresse(Adresse adresse) {this.adresse = adresse;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public Secteur getSecteur() {
        return secteur;
    }
    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
    public int getNombreDeVoie() {return nombreDeVoie;}
    public void setNombreDeVoie(int nombreDeVoie) {this.nombreDeVoie = nombreDeVoie;}
    public int getNombreDeSecteur() {return nombreDeSecteur;}
    public void setNombreDeSecteur(int nombreDeSecteur) {this.nombreDeSecteur = nombreDeSecteur;}
    public String getCotationMin() {return cotationMin;}
    public void setCotationMin(String cotationMin) {this.cotationMin = cotationMin;}
    public String getCotationMax() {return cotationMax;}
    public void setCotationMax(String cotationMax) {this.cotationMax = cotationMax;}
    public List<UrlPhoto> getListeDesPhotos() {return listeDesPhotos;}
    public void setListeDesPhotos(List<UrlPhoto> listeDesPhotos) {this.listeDesPhotos = listeDesPhotos;}

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "SiteEscalade{" +
                "idSite=" + idSite +
                ", nom='" + nom + '\'' +
                ", typeDeRoche='" + typeDeRoche + '\'' +
                ", hauteur='" + hauteur + '\'' +
                ", altitude='" + altitude + '\'' +
                ", tempsApproche='" + tempsApproche + '\'' +
                ", taguer=" + taguer +
                ", nombreDeVoie=" + nombreDeVoie +
                ", nombreDeSecteur=" + nombreDeSecteur +
                ", cotationMin='" + cotationMin + '\'' +
                ", cotationMax='" + cotationMax + '\'' +
                ", listeDesPhotos=" + listeDesPhotos +
                ", orientation=" + orientation +
                ", adresse=" + adresse +
                ", secteur=" + secteur +
                '}';
    }
}
