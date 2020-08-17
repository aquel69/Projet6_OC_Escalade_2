package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;

import java.util.List;

public interface TopoDao {

    /**
     *
     * @param id
     * @return le topo correspondant à l'id entré en paramètre
     */
    public Topo read(int id);

    /**
     *
     * @param pTopo
     * @return un boolean permettant de savoir si la requete est pas de true a false ou l'inverse
     */
    public boolean modifierDisponibiliteDUnTopo(Topo pTopo);

    /**
     *
     * @param idUtilisateur
     * @return la liste des topos d'un utilisateur
     */
    public List<Topo> readListeTopoParUtilisateur(int idUtilisateur);

    /**
     *
     * @param pTopo
     * @param pUtilisateur
     * @return l'ajout d'une reservation par un utilisateur
     */
    public Integer ajouterUneReservationTopo(Topo pTopo, Utilisateur pUtilisateur);

    /**
     *
     * @param idTopo
     * @return le topo contenant la date et l'id de l'utilisateur réservant
     */
    public Topo readReservationTopo(int idTopo);

    /**
     *
     * @param idTopo
     * @return la liste des topos réservé par topo
     */
    public List<Topo> readListeReservationTopo(int idTopo);

    /**
     *
     * @param idUtilisateur
     * @return la liste des topos réservé par l'utilisateur
     */
    public List<Topo> readListeTopoReserveParUtilisateur(int idUtilisateur);

    /**
     *
     * @return la liste de tous les topos
     */
    public List<Topo> readAllTopo();

    /**
     *
     * @param pTopo
     * @param pUtilisateur
     * @return ajoute un topo
     */
    public Integer ajouterUnTopo(Topo pTopo, Utilisateur pUtilisateur);

    /**
     *
     * @return l'id du dernier topo enregistrer dans la bdd
     */
    public int idDernierTopo();
}
