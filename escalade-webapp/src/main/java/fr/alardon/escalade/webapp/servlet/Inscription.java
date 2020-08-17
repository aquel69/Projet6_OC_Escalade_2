package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.referentiel.Pays;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.webapp.ressource.adresse.AdresseRessource;
import fr.alardon.escalade.webapp.ressource.adresse.PaysRessource;
import fr.alardon.escalade.webapp.ressource.utilisateur.UtilisateurRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Inscription")
public class Inscription extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*variables de classe*/
    private String nom = null;
    private String prenom = null;
    private String eMail = null;
    private String confirmationEMail = null;
    private String motDePasse = null;
    private String confirmationMotDePasse = null;
    private String nomUtilisateur = null;
    private Map<String, String> erreurs;
    private UtilisateurRessource utilisateurRessource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do get inscription"));

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("do post inscription");

        int strength = 10;
        String resultat;
        utilisateurRessource = new UtilisateurRessource();
        Utilisateur utilisateur = new Utilisateur();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        erreurs = new HashMap<String, String>();

        if(request.getParameter("btValiderInscription") != null) {
            /* saisie de l'utilisateur placé dans différentes variables */
            nom = request.getParameter("nom");
            prenom = request.getParameter("prenom");
            eMail = request.getParameter("Email");
            confirmationEMail = request.getParameter("confirmationEmail");
            motDePasse = request.getParameter("motDePasse");
            confirmationMotDePasse = request.getParameter("confirmationMotDePasse");
            nomUtilisateur = request.getParameter("nomUtilisateur");

            validationDesSaisies();
        }

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Vous êtes inscris sur le site des Amis de l'escalade";
        } else {
            resultat = "Échec de l'inscription.";
        }

        /* ajout dans l'objet utilisateur */
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setNomUtilisateur(nomUtilisateur);
        utilisateur.setEmail(eMail);

        utilisateur.setMotDePasse(bCryptPasswordEncoder.encode(request.getParameter("motDePasse")));

        /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute( "erreurs", erreurs );
        request.setAttribute( "resultat", resultat );

        /*ajout de l'utilisateur dans la base de données*/
        if(erreurs.isEmpty()) {
            utilisateurRessource.ajouterUnUtilisateur(utilisateur);
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }else{

            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
        }
    }

    private void validationDesSaisies(){
        /*VALIDATION DES CHAMPS*/
        /* Validation des nom et prénom */
        try {
            validationNomEtPrenom( nom, prenom );
        } catch ( Exception e ) {
            erreurs.put( "nomPrenom", e.getMessage() );
            System.out.println("probleme nom prenom");
        }
        /* Validation du pseudo. */
        try {
            validationPseudo(nomUtilisateur, utilisateurRessource.pseudoEstDejaDansLaBdd(nomUtilisateur));
        } catch ( Exception e ) {
            erreurs.put( "nomUtilisateur", e.getMessage() );
            System.out.println("probleme nom utilisateur existant");
        }
        /* Validation des champs email. */
        try {
            validationEmail(eMail, confirmationEMail, utilisateurRessource.emailEstDejaDansLaBdd(eMail));
        } catch (Exception e) {
            erreurs.put( "eMail", e.getMessage() );
            System.out.println("probleme email validation");
        }

        /* Validation des champs mot de passe et confirmation. */
        try {
            validationMotsDePasse( motDePasse, confirmationMotDePasse );
        } catch ( Exception e ) {
            erreurs.put( "motDePasse", e.getMessage() );
            System.out.println("probleme mot de passe");
        }
    }

    /**
     * valide le nom et prénom saisies
     * @param pNom
     * @param pPrenom
     * @throws Exception
     */
    private void validationNomEtPrenom(String pNom, String pPrenom) throws Exception{
        if (pNom == null && pNom.trim().length() == 0) {
            throw new Exception("Le nom est vide");
        }else if(pNom.trim().length() <= 2 || pNom.trim().length() >= 20){
            throw new Exception("Le nom doit être composer de 2 caractères minimum et de 20 maximum");
        }
        if (pPrenom == null && pPrenom.trim().length() == 0) {
            throw new Exception("Le prénom est vide");
        }else if (pPrenom.trim().length() <= 2 || pPrenom.trim().length() >= 20) {
            throw new Exception("Le prénom doit être composer de 2 caractères minimum et de 20 maximum");
        }
    }

    /**
     * Valide le pseudo saisis.
     * @param pseudo
     * @param identique
     * @throws Exception
     */
    private void validationPseudo(String pseudo, boolean identique) throws Exception{
        if( pseudo != null && pseudo.trim().length() != 0 ){
            if(identique){
                throw  new Exception("Le pseudo est déjà existant");
            }
        }
    }

    /**
     * Valide l'adresse mail saisie.
     * @param email
     * @param confirmationEmail
     * @param identique
     * @throws Exception
     */
    private void validationEmail( String email , String confirmationEmail , boolean identique ) throws Exception {
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            } else if(!email.equals(confirmationEmail)){
                throw new Exception("Les emails sont différents");
            }else if(identique == true){
                throw new Exception("L'email est déjà existant");
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    /**
     * Valide les mots de passe saisis.
     * @param motDePasse
     * @param confirmation
     * @throws Exception
     */
    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception{
        if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.trim().length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }
}
