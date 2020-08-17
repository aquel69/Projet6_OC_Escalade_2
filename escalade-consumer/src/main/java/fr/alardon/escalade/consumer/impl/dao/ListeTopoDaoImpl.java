package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.consumer.contract.dao.ListeTopoDao;
import fr.alardon.escalade.consumer.impl.rowmapper.ListeTopoRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ListeTopoDaoImpl extends AbstractDao implements ListeTopoDao {

    @Inject
    ListeTopoRM listeTopoRM;

    @Override
    public List<ListeTopoSite> readListeTopoParSite(int idSite) {

        String vSQL = "SELECT * FROM liste_topo_site_escalade as lis\n" +
                "INNER JOIN topo as top\n" +
                "         ON top.id_topo = lis.id_topo\n" +
                "INNER JOIN site_escalade as sit\n" +
                "         ON sit.id_site = lis.id_site\n" +
                "\n" +
                "WHERE sit.id_site ="+idSite;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<ListeTopoSite> vListeTopoSite = vJdbcTemplate.query(vSQL, listeTopoRM);


        return vListeTopoSite;
    }

    @Override
    public List<ListeTopoSite> readListeCompleteTopoSite() {

        String vSQL = "SELECT * FROM liste_topo_site_escalade";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<ListeTopoSite> vListeTopoSite = vJdbcTemplate.query(vSQL, listeTopoRM);

        return vListeTopoSite;
    }

    @Override
    public ListeTopoSite readTopoParSite(int idTopo) {

        String vSQL = "SELECT * FROM liste_topo_site_escalade WHERE id_topo ="+idTopo;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<ListeTopoSite> vListeTopoSite = vJdbcTemplate.query(vSQL, listeTopoRM);

        ListeTopoSite listeTopoSite = vListeTopoSite.get(0);


        return listeTopoSite;
    }


    @Override
    public Integer ajouterUnTopoALaListe(Topo pTopo, SiteEscalade pSite) {
        String vSQL = "INSERT INTO liste_topo_site_escalade (id_site, id_topo) VALUES (:idSite, :idTopo) ";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("idSite", pSite.getIdSite());
        vParams.addValue("idTopo", pTopo.getIdTopo());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }
}
