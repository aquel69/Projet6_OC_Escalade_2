package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.business.impl.manager.UtilisateurManagerImpl;
import fr.alardon.escalade.exception.NotFoundException;
import fr.alardon.escalade.webapp.ressource.utilisateur.UtilisateurRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Authentification")
public class Authentification extends HttpServlet {

    private Utilisateur utilisateurConnecte = new Utilisateur();
    private List<HttpSession> listeDesSessions = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("do get authentification");

        Utilisateur utilisateurDeco = new Utilisateur();
        HttpSession session = request.getSession(false);
        Object obj = session.getAttribute("utilisateur");
        utilisateurDeco = (Utilisateur) obj;

        /*permet à l'utilisateur d'être déconnecté*/
        if(utilisateurDeco !=null){
            for (HttpSession s : listeDesSessions) {
                System.out.println("list apres mais avant" + s);
            }
            System.out.println("utilisateur deco " +utilisateurDeco.toString());
            session.invalidate();
            System.out.println("session : " + session.toString());
            for (HttpSession s : listeDesSessions) {
                System.out.println("list apres" + s);
            }
            listeDesSessions.remove(session);
            for (HttpSession s : listeDesSessions) {
                System.out.println("list finale" + s);
            }
            this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/authentification.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int strength = 10;
        Map<String, String> erreurs = new HashMap<String, String>();
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurRessource utilisateurRessource = new UtilisateurRessource();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());


        /*je récupère dans ma jsp les données saisies*/
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        /*je les ajoute dans l'objet utilisateur*/
        utilisateur.setEmail(email);
        utilisateur.setMotDePasse(password);

        try {
            validationEmail(email, utilisateurRessource.emailNEstPasDansLaBdd(email));
        } catch (Exception e) {
            erreurs.put("eMailAuthentification", e.getMessage());
            System.out.println("probleme email validation");
        }

        if(erreurs.isEmpty()){
            /*j'envoie l'utilisateur dans ma couche business*/
            utilisateurRessource.recupererUnUtilisateur(utilisateur);

            /*je récupère l'utilisateur de la méthode de ma couche business pour savoir si les mots de passe correspondent dans mon bean*/
            utilisateurConnecte = utilisateurRessource.comparaisonMotDePasse();
        }

        if (utilisateurRessource.emailNEstPasDansLaBdd(email) == false){
            try {
                validationAuthentification(utilisateurConnecte);
            } catch (Exception e) {
                erreurs.put("authentification", e.getMessage());
                System.out.println("probleme authentification");
            }
        }

        request.setAttribute( "erreurs", erreurs );

        /*je mets l'aiguillage*/
        if(erreurs.isEmpty()) {

            if (utilisateurConnecte != null) {
                // je récupère l'utilisateur correspondant de ma base de données
                utilisateurConnecte = utilisateurRessource.readSansMotDePasse(utilisateur.getEmail());
                utilisateurConnecte.setConnecte(true);
                System.out.println("authentification" + utilisateurConnecte);

                HttpSession session = request.getSession();
                session.setAttribute("utilisateur", utilisateurConnecte);
                listeDesSessions.add(session);
                for (HttpSession s : listeDesSessions) {
                    System.out.println("list avant" + s);
                }
                /*si je suis connecté je suis redirigé vers ma page accueil*/
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/authentification.jsp").forward(request, response);
            }
        }else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/authentification.jsp").forward(request, response);
        }
    }

    /**
     * Valide l'adresse mail saisie.
     * @param email
     * @param identique
     * @throws Exception
     */
    private void validationEmail( String email , boolean identique ) throws Exception {
        if ( !email.isEmpty() || email.trim().length() != 0) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }else if(identique == true){
                throw new Exception("L'email n'est pas existant");
            }
        }
    }

    /**
     * valide l'authentification
     * @param utilisateur
     * @throws Exception
     */
    private void validationAuthentification(Utilisateur utilisateur) throws Exception{
        if(utilisateur == null){
            throw new Exception("Le mot de passe et l'email ne correspondent pas");
        }
    }
}
