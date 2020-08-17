package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.SecteurDao;
import fr.alardon.escalade.consumer.impl.rowmapper.SecteurRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named
public class SecteurDaoImpl extends AbstractDao implements SecteurDao {

    @Inject
    SecteurRM secteurRM;

    @Override
    public int getNbSecteur(int id) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrSecteur = vJdbcTemplate.queryForObject("SELECT COUNT(*) FROM secteur WHERE id_secteur="+id, Integer.class);
        return vNbrSecteur;
    }

    @Override
    public Secteur read(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM secteur WHERE id_secteur="+id;

        List<Secteur> listSecteur = jdbcTemplate.query(vSQL, secteurRM);
        Secteur secteur = listSecteur.get(0);

        return secteur;
    }

    @Override
    public List<Secteur> readAllSecteur() {
        String vSQL = "SELECT * FROM secteur";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, secteurRM);

        return vListSecteur;
    }

    public int readNombreDeSecteur(int idSite) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int count = vJdbcTemplate.queryForObject("SELECT COUNT(DISTINCT sec.nom) FROM secteur as sec WHERE id_site=" + idSite, Integer.class);

        return count;
    }

    @Override
    public Integer ajouterUnSecteur(Secteur secteur, SiteEscalade siteEscalade){
        LocalDateTime tempsCourant = LocalDateTime.now();
        String vSQL = "INSERT INTO secteur (nom, id_site) VALUES (:nom, :idSite)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", secteur.getNom());
        vParams.addValue("idSite", siteEscalade.getIdSite());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public int idDernierSecteur(){

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT currval(pg_get_serial_sequence('secteur', 'id_secteur'))";
        int id = vJdbcTemplate.queryForObject(vSQL, Integer.class);

        return id;
    }

}
