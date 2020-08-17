package fr.alardon.escalade.business.impl.manager;


import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.business.contract.manager.TopoManager;

import javax.inject.Named;
import java.util.List;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager {

    @Override
    public Topo read(int id){return getDaoFactory().getTopoDao().read(id);}

    @Override
    public boolean modifierDisponibiliteDUnTopo(Topo pTopo){return getDaoFactory().getTopoDao().modifierDisponibiliteDUnTopo(pTopo);}

    @Override
    public List<Topo> readListeTopoParUtilisateur(int idUtilisateur){return getDaoFactory().getTopoDao().readListeTopoParUtilisateur(idUtilisateur);}

    @Override
    public Integer ajouterUneReservationTopo(Topo pTopo, Utilisateur pUtilisateur){return getDaoFactory().getTopoDao().ajouterUneReservationTopo(pTopo, pUtilisateur);}

    @Override
    public List<Topo> readListeReservationTopo(int idTopo){return getDaoFactory().getTopoDao().readListeReservationTopo(idTopo);}

    @Override
    public Topo readReservationTopo(int idTopo){return getDaoFactory().getTopoDao().readReservationTopo(idTopo);}

    @Override
    public List<Topo> readListeTopoReserveParUtilisateur(int idUtilisateur){return getDaoFactory().getTopoDao().readListeTopoReserveParUtilisateur(idUtilisateur);}

    @Override
    public List<Topo> readAllTopo(){return getDaoFactory().getTopoDao().readAllTopo();}

    @Override
    public Integer ajouterUnTopo(Topo pTopo, Utilisateur pUtilisateur){return getDaoFactory().getTopoDao().ajouterUnTopo(pTopo, pUtilisateur);}

    @Override
    public int idDernierTopo(){return getDaoFactory().getTopoDao().idDernierTopo();}
}
