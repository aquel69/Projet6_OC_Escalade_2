package fr.alardon.escalade.bean.topo;

import fr.alardon.escalade.bean.site.SiteEscalade;

public class ListeTopoSite {

    // ==================== Attributs ====================
    private int idListeTopoSite;
    private SiteEscalade siteEscalade;
    private Topo topo;

    // ================== Constructeurs ==================
    public ListeTopoSite(int idListeTopoSite, SiteEscalade siteEscalade, Topo topo) {
        this.idListeTopoSite = idListeTopoSite;
        this.siteEscalade = siteEscalade;
        this.topo = topo;
    }

    public ListeTopoSite(int id_liste_topo) {this.idListeTopoSite = id_liste_topo;}

    public ListeTopoSite() {}

    // ================= Getters/Setters =================
    public int getIdListeTopoSite() {return idListeTopoSite;}
    public void setIdListeTopoSite(int idListeTopoSite) {this.idListeTopoSite = idListeTopoSite;}
    public SiteEscalade getSiteEscalade() {return siteEscalade;}
    public void setSiteEscalade(SiteEscalade siteEscalade) {this.siteEscalade = siteEscalade;}
    public Topo getTopo() {return topo;}
    public void setTopo(Topo topo) {this.topo = topo;}

    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "ListeTopoSite{" +
                "idListeTopoSite=" + idListeTopoSite +
                ", siteEscalade=" + siteEscalade +
                ", topo=" + topo +
                '}';
    }
}
