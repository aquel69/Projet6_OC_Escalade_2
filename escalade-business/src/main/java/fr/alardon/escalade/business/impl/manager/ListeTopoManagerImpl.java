package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.business.contract.manager.ListeTopoManager;

import javax.inject.Named;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Named
public class ListeTopoManagerImpl extends AbstractManager implements ListeTopoManager {

    @Override
    public List<ListeTopoSite> readListeTopoParSite(int idSite) {
        List<ListeTopoSite> listeTopoSiteEscalade = getDaoFactory().getListeTopoDao().readListeTopoParSite(idSite);
        for (ListeTopoSite liste : listeTopoSiteEscalade) {
            LocalDateTime tempsCourant = LocalDateTime.now();
            LocalDateTime tempsCommentaire = liste.getTopo().getDateDeParution();
            Period p = Period.between(tempsCommentaire.toLocalDate(), tempsCourant.toLocalDate());
            int periodeEnJour = p.getDays();
            liste.getTopo().setPeriode(periodeEnJour);
        }

        return listeTopoSiteEscalade;
    }

    @Override
    public Integer ajouterUnTopoALaListe(Topo pTopo, SiteEscalade pSite){return getDaoFactory().getListeTopoDao().ajouterUnTopoALaListe(pTopo, pSite);}

    @Override
    public ListeTopoSite readTopoParSite(int idTopo){return getDaoFactory().getListeTopoDao().readTopoParSite(idTopo);}

    @Override
    public List<ListeTopoSite> readListeCompleteTopoSite(){return getDaoFactory().getListeTopoDao().readListeCompleteTopoSite();}
}