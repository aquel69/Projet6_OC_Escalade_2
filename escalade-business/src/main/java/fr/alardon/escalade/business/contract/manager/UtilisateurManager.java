package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.exception.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UtilisateurManager {

    /**
     * Retourne l'objet Utilisateur ciblé.
     * @param pId L'identifiant de l'utilisateur ciblé.
     * @return Un objet Utilisateur.
     * @throws NotFoundException
     */
    Utilisateur read(int pId) throws NotFoundException;
    /**
     * Retourne l'objet Utilisateur ciblé.
     * @param pEmail Le mail de l'utilisateur ciblé.
     * @return Un objet Utilisateur.
     * @throws NotFoundException
     */
    Utilisateur read(String pEmail) throws NotFoundException;

    /**
     * retourne le nb d'utilisateurs dans la base de données
     * @return
     */
    int getNbUtilisateur();

    /**
     * ajoute un utilisateur
     * @param pUtilisateur
     */
    Integer ajouterUnUtilisateur(Utilisateur pUtilisateur);

    /**
     *
     * @return un booleen pour vérifier la concordance du mot de passe
     */
    Utilisateur comparaisonMotDePasse();

    /**
     *
     * @param pUtilisateur
     * @return récuperer un objet utilisateur
     */
    Utilisateur recupererUnUtilisateur(Utilisateur pUtilisateur);

    /**
     *
     * @param pPseudo
     * @return un boolean permettant de savoir si le pseudo est déjà existant
     */
    boolean pseudoEstDejaDansLaBdd(String pPseudo);

    /**
     *
     * @param pEmail
     * @return un boolean permettant de savoir si l'email est déjà existant
     */
    boolean emailEstDejaDansLaBdd(String pEmail);

    /**
     *
     * @return la liste complète des utilisateurs
     */
    public List<Utilisateur> readAllUtilisateur();

    /**
     *
     * @param pUtilisateur
     * @return un boolean pour savoir si la modification de l'utilisateur a réussi
     */
    public boolean modifierUnUtilisateur(Utilisateur pUtilisateur);

    /**
     *
     * @param pUtilisateur
     * @return un booleen permettant de savoir si la modification du mot de passe a réussi
     */
    public boolean modifierUnMotDePasseUtilisateur(Utilisateur pUtilisateur);

    /**
     *
     * @param pEmail
     * @return un booleen permettant de savoir si l'email n'est pas dans la base de données
     */
    public boolean emailNEstPasDansLaBdd(String pEmail);

    /**
     *
     * @param email
     * @return l'utilisateur sans le mot de passe à partir de son email
     */
    public Utilisateur readSansMotDePasse(String email);

    /**
     *
     * @param idUtilisateur
     * @return l'utilisateur sans le mot de passe à partir de son id
     */
    public Utilisateur readSansMotDePasse(int idUtilisateur);

}
