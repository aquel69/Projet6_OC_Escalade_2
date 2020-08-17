package fr.alardon.escalade.bean.photo;

import fr.alardon.escalade.bean.site.SiteEscalade;

public class ListePhotoSite {
    // ==================== Attributs ====================
    private int idListePhotoSite;
    private UrlPhoto urlPhoto;
    private SiteEscalade siteEscalade;

    // ================== Constructeurs ==================
    public ListePhotoSite(int idListePhotoSite, UrlPhoto urlPhoto, SiteEscalade siteEscalade) {
        this.idListePhotoSite = idListePhotoSite;
        this.urlPhoto = urlPhoto;
        this.siteEscalade = siteEscalade;
    }

    public ListePhotoSite(int id_liste_photo) {this.idListePhotoSite = id_liste_photo;}

    // ================= Getters/Setters =================
    public int getIdListePhotoSite() {return idListePhotoSite;}
    public void setIdListePhotoSite(int idListePhotoSite) {this.idListePhotoSite = idListePhotoSite;}
    public UrlPhoto getUrlPhoto() {return urlPhoto;}
    public void setUrlPhoto(UrlPhoto urlPhoto) {this.urlPhoto = urlPhoto;}
    public SiteEscalade getSiteEscalade() {return siteEscalade;}
    public void setSiteEscalade(SiteEscalade siteEscalade) {this.siteEscalade = siteEscalade;}

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "ListePhotoSite{" +
                "idListePhotoSite=" + idListePhotoSite +
                ", urlPhoto=" + urlPhoto +
                ", siteEscalade=" + siteEscalade +
                '}';
    }
}
