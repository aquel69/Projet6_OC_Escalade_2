package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    public Utilisateur read(int id);

    public Utilisateur read(String email);

    public List<Utilisateur> readAllUtilisateur();

    public Utilisateur readSansMotDePasse(int idUtilisateur);

    public int getNbUtilisateur();

    public Integer ajouterUnUtilisateur(Utilisateur pUtilisateur);

    public boolean modifierUnUtilisateur(Utilisateur pUtilisateur);

    public boolean modifierUnMotDePasseUtilisateur(Utilisateur pUtilisateur);


}
