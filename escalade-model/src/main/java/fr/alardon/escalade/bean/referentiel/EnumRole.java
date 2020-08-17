package fr.alardon.escalade.bean.referentiel;

public enum EnumRole {

    // =================== Enumeration ===================
    ADMINISTRATEUR(1, "Administrateur", "Administrateur du site de l'association."),
    MEMBRE(2, "Membre", "Membre de l'association."),
    UTILISATEUR(3, "Utilisateur", "Utilisateur du site ayant un compte.");

    // ==================== Attributs ====================
    private int code;
    private String designation;
    private String description;

    // ================== Constructeurs ==================
    EnumRole(int code, String designation, String description) {
    }

    // ================= Getters/Setters =================
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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
        return "EnumRole{" +
                "code=" + code +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
