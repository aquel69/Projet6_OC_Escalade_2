package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.consumer.contract.dao.SiteDao;
import fr.alardon.escalade.consumer.contract.dao.TopoDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class ListeTopoRM implements RowMapper<ListeTopoSite> {

    @Inject
    SiteDao siteDaoImpl;

    @Inject
    TopoDao topoDaoImpl;

    @Override
    public ListeTopoSite mapRow(ResultSet pRs, int rowNum) throws SQLException {
        ListeTopoSite listeTopoSite = new ListeTopoSite(pRs.getInt("id_liste_topo"));

        SiteEscalade vSiteEscalade = siteDaoImpl.read(pRs.getInt("id_site"));
        listeTopoSite.setSiteEscalade(vSiteEscalade);

        Topo vTopo = topoDaoImpl.read(pRs.getInt("id_topo"));
        listeTopoSite.setTopo(vTopo);

        return listeTopoSite;
    }

}
