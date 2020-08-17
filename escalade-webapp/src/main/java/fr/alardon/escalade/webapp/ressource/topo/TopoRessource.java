package fr.alardon.escalade.webapp.ressource.topo;

import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class TopoRessource extends AbstractRessource {

    public Topo read(int idTopo){return getManagerFactory().getTopoManager().read(idTopo);}

    public boolean modifierDisponibiliteDUnTopo(Topo pTopo){return getManagerFactory().getTopoManager().modifierDisponibiliteDUnTopo(pTopo);}

    public List<Topo> readListeTopoParUtilisateur(int idUtilisateur){return getManagerFactory().getTopoManager().readListeTopoParUtilisateur(idUtilisateur);}

    public Integer ajouterUneReservationTopo(Topo pTopo, Utilisateur pUtilisateur){return getManagerFactory().getTopoManager().ajouterUneReservationTopo(pTopo, pUtilisateur);}

    public Topo readReservationTopo(int idTopo){return getManagerFactory().getTopoManager().readReservationTopo(idTopo);}

    public List<Topo> readListeTopoReserveParUtilisateur(int idUtilisateur){return  getManagerFactory().getTopoManager().readListeTopoReserveParUtilisateur(idUtilisateur);}

    public List<Topo> readAllTopo(){return getManagerFactory().getTopoManager().readAllTopo();}

    public Integer ajouterUnTopo(Topo pTopo, Utilisateur pUtilisateur){return getManagerFactory().getTopoManager().ajouterUnTopo(pTopo, pUtilisateur);}

    public int idDernierTopo(){return getManagerFactory().getTopoManager().idDernierTopo();}
}
