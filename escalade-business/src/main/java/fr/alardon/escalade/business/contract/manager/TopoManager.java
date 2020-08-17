package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;

import java.util.List;

public interface TopoManager {

    public Topo read(int id);

    public boolean modifierDisponibiliteDUnTopo(Topo pTopo);

    public List<Topo> readListeTopoParUtilisateur(int idUtilisateur);

    public Integer ajouterUneReservationTopo(Topo pTopo, Utilisateur pUtilisateur);

    public Topo readReservationTopo(int idTopo);

    public List<Topo> readListeTopoReserveParUtilisateur(int idUtilisateur);

    public List<Topo> readAllTopo();

    public Integer ajouterUnTopo(Topo pTopo, Utilisateur pUtilisateur);

    public int idDernierTopo();

    public List<Topo> readListeReservationTopo(int idTopo);
}
