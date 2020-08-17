package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;

import java.util.List;

public interface ListeTopoDao {

    /**
     *
     * @param idSite
     * @return la liste des topos d'un site
     */
    public List<ListeTopoSite> readListeTopoParSite(int idSite);

    /**
     *
     * @param pTopo
     * @param pSite
     * @return ajoute un topo à la liste
     */
    public Integer ajouterUnTopoALaListe(Topo pTopo, SiteEscalade pSite);

    /**
     *
     * @param idTopo
     * @return le site correspondant au topo
     */
    public ListeTopoSite readTopoParSite(int idTopo);

    /**
     *
     * @return la liste complete des topos / sites
     */
    public List<ListeTopoSite> readListeCompleteTopoSite();

}
