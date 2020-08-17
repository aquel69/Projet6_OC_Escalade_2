package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;

import java.util.List;

public interface ListeTopoManager {

    public List<ListeTopoSite> readListeTopoParSite(int idSite);

    public Integer ajouterUnTopoALaListe(Topo pTopo, SiteEscalade pSite);

    public ListeTopoSite readTopoParSite(int idTopo);

    public List<ListeTopoSite> readListeCompleteTopoSite();
}
