package fr.alardon.escalade.bean.referentiel;

public class Cotation {
    // ==================== Attributs ====================
    private String cotation;
    private String description;

    // ================== Constructeurs ==================
    public Cotation(String cotation, String description) {
        this.cotation = cotation;
        this.description = description;
    }

    public Cotation(String cotation) {this.cotation = cotation;}

    public Cotation() {

    }

    // ================= Getters/Setters =================
    public String getCotation() { return cotation;}
    public void setCotation(String cotation) {this.cotation = cotation;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "Cotation{" +
                "cotation='" + cotation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
