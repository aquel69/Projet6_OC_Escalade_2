package fr.alardon.escalade.bean.referentiel;

public class Pays {

    // ==================== Attributs ====================
    /**
     * Nom du pays
     */
    private String nom = "France";
    /**
     * Code pays ISO 3166-1 alpha 2
     */
    private String  codeAlpha2 = "FR";
    /**
     * Code pays ISO 3166-1 alpha 3
     */
    private String codeAlpha3 = "FRA";
    /**
     * Code pays ISO 3166-1au format numérique
     */
    private Integer code = 250;

    // Exemple pour la France :
    // France	FR	FRA	250

    // ================== Constructeurs ==================
    /**
     * Constructeur complet.
     * @param nom
     * @param codeAlpha2
     * @param codeAlpha3
     * @param code
     */
    public Pays(String nom, String codeAlpha2, String codeAlpha3, Integer code) {
        this.nom = nom;
        this.codeAlpha2 = codeAlpha2;
        this.codeAlpha3 = codeAlpha3;
        this.code = code;
    }

    public Pays(int code) {this.code = code;}

    public Pays() {

    }

    // ================= Getters/Setters =================
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCodeAlpha2() {
        return codeAlpha2;
    }
    public void setCodeAlpha2(String codeAlpha2) {
        this.codeAlpha2 = codeAlpha2;
    }
    public String getCodeAlpha3() {
        return codeAlpha3;
    }
    public void setCodeAlpha3(String codeAlpha3) {
        this.codeAlpha3 = codeAlpha3;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "Pays{" +
                "nom='" + nom + '\'' +
                ", codeAlpha2='" + codeAlpha2 + '\'' +
                ", codeAlpha3='" + codeAlpha3 + '\'' +
                ", code=" + code +
                '}';
    }
}
