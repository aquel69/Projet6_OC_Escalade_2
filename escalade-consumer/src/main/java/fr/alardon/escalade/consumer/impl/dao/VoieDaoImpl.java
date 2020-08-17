package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.site.Voie;
import fr.alardon.escalade.consumer.contract.dao.VoieDao;
import fr.alardon.escalade.consumer.impl.rowmapper.VoieRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named
public class VoieDaoImpl extends AbstractDao implements VoieDao {

    @Inject
    VoieRM voieRM;

    @Override
    public List<Voie> readVoieRapportSite(int idSite){
        String vSQL = "SELECT * FROM voie as voi\n" +
                "INNER JOIN secteur as sec\n" +
                "ON voi.id_secteur = sec.id_secteur\n" +
                "INNER JOIN  site_escalade as sit\n" +
                "ON sec.id_site = sit.id_site\n" +
                "INNER JOIN adresse as adr\n" +
                "ON sit.adresse = adr.id_adresse\n" +
                "WHERE sit.id_site="+ idSite;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Voie> vListVoie = vJdbcTemplate.query(vSQL, voieRM);

        return vListVoie;
    }

    public int readNombreDeVoie(int idSite) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int count = vJdbcTemplate.queryForObject("SELECT COUNT(DISTINCT \"voi\")\n" +
                "FROM voie as voi, secteur as sec, site_escalade as sit\n" +
                "WHERE voi.id_secteur = sec.id_secteur\n" +
                "  AND sit.id_site = sec.id_site\n" +
                "GROUP BY sit.id_site\n" +
                "HAVING sit.id_site =" + idSite, Integer.class);

        return count;
    }

    @Override
    public Integer ajouterUneVoie(Voie voie, Secteur secteur, Cotation cotation){
        String vSQL = "INSERT INTO voie (numero_de_voie, nom, cotation, id_secteur) VALUES (:numeroDeVoie, :nom, :cotation, :idSecteur)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("numeroDeVoie", voie.getNumeroDeVoie());
        vParams.addValue("nom", voie.getNom());
        vParams.addValue("cotation", cotation.getCotation());
        vParams.addValue("idSecteur", secteur.getIdSecteur());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

}
