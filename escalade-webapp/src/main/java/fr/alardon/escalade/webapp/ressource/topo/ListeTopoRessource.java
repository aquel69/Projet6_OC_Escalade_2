package fr.alardon.escalade.webapp.ressource.topo;

import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class ListeTopoRessource extends AbstractRessource {

    public List<ListeTopoSite> readListeTopoParSite(int idSite){return getManagerFactory().getListeTopoManager().readListeTopoParSite(idSite);}

    public Integer ajouterUnTopoALaListe(Topo pTopo, SiteEscalade pSite){return getManagerFactory().getListeTopoManager().ajouterUnTopoALaListe(pTopo, pSite);}

    public ListeTopoSite readTopoParSite(int idTopo){return getManagerFactory().getListeTopoManager().readTopoParSite(idTopo);}

    public List<ListeTopoSite> readListeCompleteTopoSite(){return getManagerFactory().getListeTopoManager().readListeCompleteTopoSite();}

}
