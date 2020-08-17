package fr.alardon.escalade.bean.photo;

public class UrlPhoto {

    // ==================== Attributs ====================
    private Integer idUrl;
    private String url;
    private String description;

    // ================== Constructeurs ==================
    public UrlPhoto(Integer idUrl, String url, String description) {
        this.idUrl = idUrl;
        this.url = url;
        this.description = description;
    }

    public UrlPhoto(int idUrl) {this.idUrl = idUrl;}

    public UrlPhoto() {

    }

    // ================= Getters/Setters =================
    public Integer getIdUrl() {
        return idUrl;
    }
    public void setIdUrl(Integer idUrl) {
        this.idUrl = idUrl;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "UrlPhoto{" +
                "id=" + idUrl +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}



