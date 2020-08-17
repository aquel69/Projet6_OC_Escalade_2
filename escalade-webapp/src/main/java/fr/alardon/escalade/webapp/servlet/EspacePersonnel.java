package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.adresse.Adresse;
import fr.alardon.escalade.bean.referentiel.Departement;
import fr.alardon.escalade.bean.referentiel.Pays;
import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.webapp.ressource.adresse.AdresseRessource;
import fr.alardon.escalade.webapp.ressource.adresse.DepartementRessource;
import fr.alardon.escalade.webapp.ressource.adresse.PaysRessource;
import fr.alardon.escalade.webapp.ressource.adresse.RegionRessource;
import fr.alardon.escalade.webapp.ressource.utilisateur.UtilisateurRessource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

@WebServlet(name = "EspacePersonnel")
public class EspacePersonnel extends HttpServlet {

    /*variables de classe*/
    private Utilisateur utilisateur;
    private HttpSession session;
    private Object objRecuperationSession;
    private int indiceVue = 0;
    private PaysRessource paysRessource;
    private DepartementRessource departementRessource;
    private RegionRessource regionRessource;
    private List<Pays> listeDesPays;
    private List<Departement> listeDesDepartements;
    private List<Region> listeDesRegions;
    private Map<String, String> coordonnesUtilisateur;
    private Map<String, String> erreurs;
    private String prenom = null;
    private String nom = null;
    private String eMail = null;
    private String nomUtilisateur = null;
    private String adresseDomicile = null;
    private String ville = null;
    private String codePostal = null;
    private String paysDomicile = null;
    private String regionDomicile = null;
    private String departementDomicile = null;
    private String eMailAModifier = null;
    private String motDePasseActuel = null;
    private String nouveauMotDePasse = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do get Espace Personnel"));

        /*récupération de l'utilisateur de la session*/
        utilisateur = new Utilisateur();
        session = request.getSession(false);
        objRecuperationSession = session.getAttribute("utilisateur");
        utilisateur = (Utilisateur) objRecuperationSession;

        /*permet d'afficher les différents élément de la page en fonction de l'avancer de l'inscription*/
        affichageDesDifférentesVuesSelonConnectionUtilisateur();

        /*Ajout Pays, Région, Département*/
        ajoutPaysRegionDepartement(request);

        /*envoi à la JSP*/
        request.setAttribute("indiceVue", indiceVue);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/espacePersonnel.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do post Espace Personnel"));

        session.getAttribute("utilisateur");

        /*déclaration des variables*/
        erreurs = new HashMap<String, String>();
        String resultat = null;

        /*Ajout Pays, Région, Département*/
        ajoutPaysRegionDepartement(request);

        eMail = request.getParameter("Email");
        eMailAModifier = request.getParameter("modifierEmail");
        motDePasseActuel = request.getParameter("motDePasse");
        nouveauMotDePasse = request.getParameter("nouveauMotDePasse");

        if(request.getParameter("btValidationIdentite") != null){
            /*affectation des saisies utilisateur aux variables*/
            getParametresModificationDeCompte(request);

            modificationUtilisateur(request);
            if(erreurs.isEmpty())resultat = "Le compte a été modifié";
        }

        if(request.getParameter("btValideEmailMDP") != null){
            /*variable modification du compte*/
            eMailAModifier = request.getParameter("modifierEmail");
            motDePasseActuel = request.getParameter("motDePasse");
            nouveauMotDePasse = request.getParameter("nouveauMotDePasse");

            modificationEmailMotDePasse(request);
            if(erreurs.isEmpty())resultat = "Le compte a été modifié";
        }

        /*envoi à la JSP*/
        session.setAttribute("utilisateur", utilisateur);
        request.setAttribute("indiceVue", indiceVue);
        request.setAttribute("erreurs", erreurs);
        request.setAttribute("resultatCompte", resultat);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/espacePersonnel.jsp").forward(request, response);
    }

    private void getParametresModificationDeCompte(HttpServletRequest request) {
        nom = request.getParameter("nom");
        prenom = request.getParameter("prenom");
        nomUtilisateur = request.getParameter("pseudo");
        adresseDomicile = request.getParameter("adresse");
        ville = request.getParameter("ville");
        codePostal = request.getParameter("codePostal");
        paysDomicile = request.getParameter("pays");
        regionDomicile = request.getParameter("region");
        departementDomicile = request.getParameter("departement");
    }


    /*méthodes*/
    private void modificationUtilisateur(HttpServletRequest request){
        Departement departement = new Departement();
        Pays pays = new Pays();
        Region region = new Region();
        Adresse adresse = new Adresse();
        AdresseRessource adresseRessource = new AdresseRessource();
        UtilisateurRessource utilisateurRessource = new UtilisateurRessource();

        /*affectation objet pays/region/département*/
        pays = paysRessource.read(paysDomicile.trim());
        if(paysDomicile.trim().toUpperCase().equals("FRANCE")){
            region = regionRessource.read(regionDomicile.trim());
        }else{
            region = null;
        }
        if(paysDomicile.trim().toUpperCase().equals("FRANCE")){
            departement = departementRessource.read(departementDomicile.trim());
        }else{
            departement = null;
        }

        /*ajout dans l'objet adresse*/
        /*adresse.setIdAdresse(utilisateur.getAdresse().getIdAdresse());*/
        adresse.setAdresse(adresseDomicile);
        adresse.setVille(ville);
        adresse.setCodePostal(codePostal);
        adresse.setPays(pays);
        adresse.setRegion(region);
        adresse.setDepartement(departement);

        /*vérification de l'objet adresse*/
        try {
            validationAdressePostale(adresse);
        } catch (Exception e) {
            erreurs.put("adresse", e.getMessage());
            System.out.println("problème adresse postale");
        }
        try {
            validationCodePostal(adresse);
        } catch (Exception e) {
            erreurs.put("codePostal", e.getMessage());
            System.out.println("problème code postal");
        }
        try {
            validationVille(adresse);
        } catch (Exception e) {
            erreurs.put("ville", e.getMessage());
            System.out.println("problème nom de la ville");
        }
        try {
            validationPays(adresse);
        } catch (Exception e) {
            erreurs.put("pays", e.getMessage());
            System.out.println("problème pays");
        }
        try {
            validationRegionDepartement(adresse);
        } catch (Exception e) {
            erreurs.put("region", e.getMessage());
            System.out.println("problème region departement");
        }

        if(erreurs.isEmpty()){
            if (adresse.getPays().getNom().equals("FRANCE")) {
                adresseRessource.modifierUneAdresse(adresse);
            } else adresseRessource.modifierUneAdresseSansRegionDepartement(adresse);
        }

        /*ajout de l'adresse  l'utilisateur et modification de la session utilisateur*/
        utilisateur.setAdresse(adresse);

        /*validation nom et prenom*/
        if(!nom.isEmpty() || !prenom.isEmpty()) {
            try {
                validationNomEtPrenom(nom, prenom);

            } catch (Exception e) {
                erreurs.put("nomPrenom", e.getMessage());
                System.out.println("probleme nom ou prenom validation");
            }
        }

        /* Validation du pseudo*/
        if (!nomUtilisateur.equals(utilisateur.getNomUtilisateur())){
            try {
                validationPseudo(nomUtilisateur, utilisateurRessource.pseudoEstDejaDansLaBdd(nomUtilisateur));
            } catch (Exception e) {
                erreurs.put("nomUtilisateur", e.getMessage());
                System.out.println("probleme nom utilisateur existant");
            }
        }

        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setNomUtilisateur(nomUtilisateur);
        if(erreurs.isEmpty()){
            utilisateurRessource.modifierUnUtilisateur(utilisateur);
        }
    }

    private void modificationEmailMotDePasse(HttpServletRequest request){
        int strength = 10;
        Utilisateur utilisateurPassword = new Utilisateur();
        UtilisateurRessource utilisateurRessource = new UtilisateurRessource();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());

        /* Validation des champs email. */
        if(eMailAModifier != null) {
            try {
                validationEmail(eMailAModifier, utilisateurRessource.emailEstDejaDansLaBdd(eMailAModifier));
            } catch (Exception e) {
                erreurs.put("email", e.getMessage());
                System.out.println("probleme email validation");
            }
        }
        /* Validation des champs mot de passe et confirmation. */
        if(motDePasseActuel != null && nouveauMotDePasse != null) {
            try {
                validationMotsDePasse(motDePasseActuel, nouveauMotDePasse);
            } catch (Exception e) {
                erreurs.put("motDePasse", e.getMessage());
                System.out.println("probleme mot de passe");
            }
        }

        if(erreurs.isEmpty()) {
            /*utilisateur mot de passe*/
            utilisateurPassword.setMotDePasse(motDePasseActuel);
            utilisateurPassword.setEmail(eMail);

            if (motDePasseActuel != null && nouveauMotDePasse != null && !motDePasseActuel.trim().isEmpty() && !nouveauMotDePasse.trim().isEmpty()) {
                /*j'envoie l'utilisateur dans ma couche business*/
                Utilisateur utilisateurMotDePasse = utilisateur;
                utilisateurRessource.recupererUnUtilisateur(utilisateurPassword);
                /*je récupère l utilisateur de la méthode de ma couche business pour savoir si les mots de passe correspondent dans mon bean*/
                utilisateurMotDePasse = utilisateurRessource.comparaisonMotDePasse();
                if (utilisateurMotDePasse != null) {
                    utilisateurMotDePasse.setIdUtilisateur(utilisateur.getIdUtilisateur());
                    utilisateurMotDePasse.setMotDePasse(bCryptPasswordEncoder.encode(request.getParameter("nouveauMotDePasse")));
                    utilisateurRessource.modifierUnMotDePasseUtilisateur(utilisateurMotDePasse);
                }else{
                    erreurs.put("motDePasseActuel", "Le mot de passe entré ne correspond pas");
                }
            }

            /*modification de l'email*/
            if (eMailAModifier != null && !eMailAModifier.trim().isEmpty()) {
                utilisateur.setEmail(eMailAModifier);
            } else {
                utilisateur.setEmail(eMail);
            }

            if(erreurs.isEmpty()){
                utilisateurRessource.modifierUnUtilisateur(utilisateur);
            }
        }
    }

    /**
     * permet de changer la vue en fonction de l'avancé de l'inscription de l'utilisateur
     */
    private void affichageDesDifférentesVuesSelonConnectionUtilisateur(){
        if(utilisateur == null) {
            indiceVue = -1;
        }else if (utilisateur.getAdresse() == null){
            indiceVue = 0;
        }else{
            indiceVue = utilisateur.getAdresse().getIdAdresse();
        }
    }

    /**
     *
     * @param request
     */
    private void ajoutPaysRegionDepartement(HttpServletRequest request){
        listeDesPays = new ArrayList<>();
        listeDesDepartements = new ArrayList<>();
        listeDesRegions = new ArrayList<>();
        paysRessource = new PaysRessource();
        regionRessource = new RegionRessource();
        departementRessource = new DepartementRessource();

        //ajout des pays
        listeDesPays = paysRessource.readAllPays();

        //ajout des départements
        listeDesDepartements = departementRessource.readAllDepartement();

        //ajout des Régions
        listeDesRegions = regionRessource.readAllRegion();

        request.setAttribute("listeDesPays", listeDesPays);
        request.setAttribute("listeDesDepartements", listeDesDepartements);
        request.setAttribute("listeDesRegions", listeDesRegions);
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
     * Valide le pseudo saisie
     * @param pseudo
     * @param identique
     * @throws Exception
     */
    private void validationPseudo(String pseudo, boolean identique) throws Exception{
        if(pseudo.trim().length() == 0){
            throw  new Exception("Le champ pseudo est vide");
        }else if( pseudo != null && pseudo.trim().length() != 0 ){
            if(identique){
                throw  new Exception("Le pseudo est déjà existant");
            }
        }
    }

    /**
     * Valide l'adresse postale saisie
     * @param adresse
     * @throws Exception
     */
    private void validationAdressePostale(Adresse adresse) throws Exception {
        if (adresse.getAdresse().isEmpty()) {
            throw new Exception("L'adresse n'est pas renseignée");
        }
    }

    /**
     * Valide le code postal saisie
     * @param adresse
     * @throws Exception
     */
    private void validationCodePostal(Adresse adresse) throws Exception{
        if(adresse.getCodePostal().isEmpty()) {
            throw new Exception("Le code Postal n'est pas renseigné");
        }
    }

    /**
     * Valide la ville saisie
     * @param adresse
     * @throws Exception
     */
    private void validationVille(Adresse adresse) throws Exception{
        if(adresse.getVille().isEmpty()){
            throw  new Exception("La ville n'est pas renseignée");
        }
    }

    /**
     * Valide le pays saisie
     * @param adresse
     * @throws Exception
     */
    private void validationPays(Adresse adresse) throws Exception{
        if(adresse.getPays() == null){
            throw new Exception("Le pays n'est pas renseigné");
        }
    }

    private void validationRegionDepartement(Adresse adresse) throws Exception{
        if(adresse.getPays().getNom().equals("FRANCE")){
            if(adresse.getRegion() == null || adresse.getDepartement() == null){
                throw new Exception("La région et le département ne sont pas renseignés");
            }
        }else{
            if(adresse.getRegion() != null || adresse.getDepartement() != null){
                throw new Exception("La région et le département ne doivent pas être renseignés");
            }
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
                throw new Exception("L'email est déjà existant");
            }
        }
    }

    /**
     * Valide les mots de passe saisis.
     * @param motDePasse
     * @throws Exception
     */
    private void validationMotsDePasse( String motDePasse, String nouveauMotDePasse ) throws Exception{
        if (!motDePasse.isEmpty() || motDePasse.trim().length() != 0 || !nouveauMotDePasse.isEmpty() || motDePasse.trim().length() != 0) {
            if  (motDePasse.trim().length() < 3 || nouveauMotDePasse.trim().length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        }
    }
}
