package fr.alardon.escalade.bean.referentiel;

public class Orientation {
    // ==================== Attributs ====================
    private String abreviation;
    private String direction;

    // ================== Constructeurs ==================
    public Orientation(String abreviation, String direction) {
        this.abreviation = abreviation;
        this.direction = direction;
    }

    public Orientation(String abreviation) {this.abreviation = abreviation;}

    public Orientation() {

    }

    // ================= Getters/Setters =================
    public String getAbreviation() {return abreviation;}
    public void setAbreviation(String abreviation) {this.abreviation = abreviation;}
    public String getDirection() {return direction;}
    public void setDirection(String direction) {this.direction = direction;}

    // ==================== Méthodes =====================
    @Override
    public String toString() {
        return "Orientation{" +
                "abreviation='" + abreviation + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
