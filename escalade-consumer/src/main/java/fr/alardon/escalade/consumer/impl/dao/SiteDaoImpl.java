package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.consumer.contract.dao.SiteDao;
import fr.alardon.escalade.consumer.impl.rowmapper.CotationRM;
import fr.alardon.escalade.consumer.impl.rowmapper.OrientationRM;
import fr.alardon.escalade.consumer.impl.rowmapper.SiteCompletRM;
import fr.alardon.escalade.consumer.impl.rowmapper.SiteRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDao implements SiteDao {
    @Inject
    SiteRM siteRM;

    @Inject
    SiteCompletRM siteCompletRM;

    @Inject
    CotationRM cotationRM;

    @Inject
    OrientationRM orientationRM;

    @Override
    public Integer ajouterUnSite(SiteEscalade siteEscalade){
        String vSQL = "INSERT INTO site_escalade (type_de_roche, orientation, taguer, hauteur, altitude, temps_d_approche, adresse, nom) VALUES (:typeDeRoche, :orientation, :taguer, :hauteur, :altitude, :tempsDApproche, :adresse, :nom)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("typeDeRoche",siteEscalade.getTypeDeRoche());
        vParams.addValue("orientation", siteEscalade.getOrientation().getAbreviation());
        vParams.addValue("taguer", siteEscalade.isTaguer());
        vParams.addValue("hauteur", siteEscalade.getHauteur());
        vParams.addValue("altitude", siteEscalade.getAltitude());
        vParams.addValue("tempsDApproche", siteEscalade.getTempsApproche());
        vParams.addValue("adresse", siteEscalade.getAdresse().getIdAdresse());
        vParams.addValue("nom", siteEscalade.getNom());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public int idDernierSite(){

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT currval(pg_get_serial_sequence('site_escalade', 'id_site'))";
        int id = vJdbcTemplate.queryForObject(vSQL, Integer.class);

        return id;
    }

    @Override
    public List<SiteEscalade> readAllSiteEscalade(){
        String vSQL = "SELECT * FROM site_escalade";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<SiteEscalade> vListSiteEscalade = vJdbcTemplate.query(vSQL, siteCompletRM);

        return vListSiteEscalade;
    }

    @Override
    public List<SiteEscalade> readAllSiteEscaladeSansSecteurPhoto(){
        String vSQL = "SELECT * FROM site_escalade";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<SiteEscalade> vListSiteEscalade = vJdbcTemplate.query(vSQL, siteRM);

        return vListSiteEscalade;
    }

    @Override
    public SiteEscalade read(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM site_escalade WHERE id_site="+id;

        List<SiteEscalade> listSite = jdbcTemplate.query(vSQL, siteRM);
        SiteEscalade site = listSite.get(0);

        return site;
    }

    @Override
    public SiteEscalade read(String nomDuSite) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM site_escalade WHERE nom=\'" + nomDuSite + "\'";

        List<SiteEscalade> listSite = jdbcTemplate.query(vSQL, siteRM);
        SiteEscalade site = listSite.get(0);

        return site;
    }

    @Override
    public List<SiteEscalade> readPageDetailSite(){
        String vSQL = "SELECT sit.id_site, sit.nom, sit.altitude, sit.hauteur, sit.taguer, sit.temps_d_approche, sit.type_de_roche, ori.direction, adr.adresse, adr.ville, adr.code_postal, MIN(voi.cotation), MAX(voi.cotation), COUNT(DISTINCT \"sec\"), count(\"voi\")\n" +
                "FROM site_escalade as sit, secteur as sec, voie as voi, orientation as ori, adresse as adr\n" +
                "WHERE sec.id_site = sit.id_site\n" +
                "AND voi.id_secteur = sec.id_secteur\n" +
                "AND sit.adresse = adr.id_adresse\n" +
                "AND ori.abreviation = sit.orientation\n" +
                "AND sec.id_site = sit.id_site\n" +
                "AND voi.id_secteur = sec.id_secteur\n" +
                "GROUP BY sit.id_site, ori.direction, adr.id_adresse";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<SiteEscalade> vListSiteEscalade = vJdbcTemplate.query(vSQL, siteCompletRM);

        return vListSiteEscalade;
    }

    public String readCotationSiteMin(int idSite) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String min = vJdbcTemplate.queryForObject("SELECT MIN (voi.cotation)\n" +
                "        FROM voie as voi, secteur as sec, site_escalade as sit\n" +
                "        WHERE voi.id_secteur = sec.id_secteur\n" +
                "        AND sit.id_site = sec.id_site\n" +
                "        GROUP BY sit.id_site\n" +
                "        HAVING sit.id_site =" + idSite, String.class);

        return min;
    }

    public String readCotationSiteMax(int idSite) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String max = vJdbcTemplate.queryForObject("SELECT MAX (voi.cotation)\n" +
                "        FROM voie as voi, secteur as sec, site_escalade as sit\n" +
                "        WHERE voi.id_secteur = sec.id_secteur\n" +
                "        AND sit.id_site = sec.id_site\n" +
                "        GROUP BY sit.id_site\n" +
                "        HAVING sit.id_site =" + idSite, String.class);

        return max;
    }

    @Override
    public List<Cotation> readAllCotation(){
        String vSQL = "SELECT * FROM cotation";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Cotation> vListCotation = vJdbcTemplate.query(vSQL, cotationRM);

        return vListCotation;
    }

    @Override
    public List<Orientation> readAllOrientation(){
        String vSQL = "SELECT * FROM orientation";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Orientation> vListOrientation = vJdbcTemplate.query(vSQL, orientationRM);

        return vListOrientation;
    }

}
