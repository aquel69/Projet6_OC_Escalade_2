package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.adresse.Adresse;
import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.bean.referentiel.Pays;
import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.site.Voie;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.webapp.ressource.adresse.AdresseRessource;
import fr.alardon.escalade.webapp.ressource.adresse.PaysRessource;
import fr.alardon.escalade.webapp.ressource.escalade.SecteurRessource;
import fr.alardon.escalade.webapp.ressource.escalade.SiteRessource;
import fr.alardon.escalade.webapp.ressource.escalade.VoieRessource;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ajoutSite")
public class AjoutSite extends HttpServlet {

    private Utilisateur utilisateur;
    private HttpSession session;
    private Object objRecuperationSession;
    private int indiceVue = 0;
    private SiteRessource siteRessource;
    private PaysRessource paysRessource;
    private List<Cotation> listeDesCotations;
    private List<Orientation> listeDesOrientations;
    private List<Pays> listeDesPays;
    private List<String[]> listeDesVoies;
    private Map<String, String> erreurs;
    private String nomSecteur = null;
    private String numeroVoie = null;
    private String nomVoie = null;
    private String cotationString = null;
    private String nom = null;
    private String adresse = null;
    private String ville = null;
    private String codePostal = null;
    private String altitude = null;
    private String orientationString = null;
    private String hauteurDuSite = null;
    private String tempsApproche = null;
    private String typeDeRoche = null;
    private String nomPays = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do get ajoutSite2"));

        listeDesVoies = new ArrayList<>();

        /*récupération de l'utilisateur de la session*/
        utilisateur = new Utilisateur();
        session = request.getSession(false);
        objRecuperationSession = session.getAttribute("utilisateur");
        utilisateur = (Utilisateur) objRecuperationSession;

        indiceVue = affichagePageEnFonctionDeLUtilisateur();
        affichageDesListesDeroulantes();

        /*envoi à la JSP*/
        request.setAttribute("listeDesCotations", listeDesCotations);
        request.setAttribute("listeDesOrientations", listeDesOrientations);
        request.setAttribute("listeDesPays", listeDesPays);
        request.setAttribute("indiceVue", indiceVue);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajoutSite.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("do post ajoutSite2");

        /*déclaration des variables*/
        erreurs = new HashMap<String, String>();
        String resultat = null;

        if(request.getParameter("btValidationVoies") != null){
            verificationDesSaisiesSecteurVoie(request);
            if(erreurs.isEmpty()) {
                listeDesVoies.add(ajoutDUneVoie());
            }
        }
        if(request.getParameter("btValidationAjoutSite") != null){
            verificationDesSaisiesGlobales(request);
            if(erreurs.isEmpty()) {
                ajoutDuSite();
            }
        }

        /*envoi à la JSP*/
        request.setAttribute("listeDesVoies", listeDesVoies);
        request.setAttribute("erreurs", erreurs);
        request.setAttribute("listeDesCotations", listeDesCotations);
        request.setAttribute("listeDesOrientations", listeDesOrientations);
        request.setAttribute("listeDesPays", listeDesPays);
        request.setAttribute("indiceVue", indiceVue);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajoutSite.jsp").forward(request, response);
    }

    private void ajoutDuSite(){
        Adresse adresseComplete = new Adresse();
        Pays pays = new Pays();
        AdresseRessource adresseRessource = new AdresseRessource();
        Orientation orientation = new Orientation();
        SiteEscalade siteEscalade = new SiteEscalade();
        Secteur secteurGlobal = new Secteur();
        SecteurRessource secteurRessource = new SecteurRessource();
        Voie voieGlobale = new Voie();
        VoieRessource voieRessource = new VoieRessource();
        Cotation cotation = new Cotation();

        /*ADRESSE*/
        /*ajout de l'adresse*/
        adresseComplete.setAdresse(adresse);
        adresseComplete.setVille(ville);
        adresseComplete.setCodePostal(codePostal);
        pays = paysRessource.read(nomPays);
        adresseComplete.setPays(pays);
        adresseRessource.ajouterUneAdresseSansRegionDepartement(adresseComplete);
        /*on recupere l'id de l'adresse*/
        int idAdresse = adresseRessource.idDerniereAdresse();
        /*on l'ajoute au bean*/
        adresseComplete.setIdAdresse(idAdresse);

        /*ORIENTATION*/
        orientation.setAbreviation(orientationString);

        /*SITE ESCALADE*/
        /*ajout du site dans la bdd*/
        siteEscalade.setNom(nom);
        siteEscalade.setTypeDeRoche(typeDeRoche);
        siteEscalade.setAdresse(adresseComplete);
        siteEscalade.setAltitude(altitude);
        siteEscalade.setHauteur(hauteurDuSite);
        siteEscalade.setOrientation(orientation);
        siteEscalade.setTempsApproche(tempsApproche);
        siteEscalade.setTaguer(false);
        siteRessource.ajouterUnSite(siteEscalade);
        /*ajout de l'id site*/
        int idSite = siteRessource.idDernierSite();
        siteEscalade.setIdSite(idSite);

        /*SECTEUR VOIE COTATION*/
        for (String[] p: listeDesVoies){
            /*ajout du secteur*/
            System.out.println("tableau : " + p[0] + p[1] + p[2] +p[3]);
            nomSecteur = p[0];
            secteurGlobal.setNom(nomSecteur);
            secteurRessource.ajouterUnSecteur(secteurGlobal, siteEscalade);
            int idDernierSecteur = secteurRessource.idDernierSecteur();
            secteurGlobal.setIdSecteur(idDernierSecteur);

            /*ajout de la voie*/
            voieGlobale.setNumeroDeVoie(p[1]);
            voieGlobale.setNom(p[2]);
            cotation.setCotation(p[3]);
            voieRessource.ajouterUneVoie(voieGlobale, secteurGlobal, cotation);
        }

        String resultat = "Vous avez ajouté un site";
        session.setAttribute("resultat", resultat);

    }

    private void verificationDesSaisiesGlobales(HttpServletRequest request){
        /*récupération des champs*/
        nom = request.getParameter("nom");
        adresse = request.getParameter("adresse");
        ville = request.getParameter("ville");
        codePostal = request.getParameter("codePostal");
        nomPays = request.getParameter("pays");
        hauteurDuSite = request.getParameter("hauteurDuSite");
        tempsApproche = request.getParameter("tempsApproche");
        typeDeRoche = request.getParameter("typeDeRoche");
        altitude = request.getParameter("altitude");
        orientationString = request.getParameter("orientation");

        try {
            validationNomSite(nom);
        } catch (Exception e) {
            erreurs.put("nom", e.getMessage());
            System.out.println("problème nom site");
        }
        try {
            validationAdressePostale(adresse);
        } catch (Exception e) {
            erreurs.put("adresse", e.getMessage());
            System.out.println("problème adresse site");
        }
        try {
            validationCodePostal(codePostal);
        } catch (Exception e) {
            erreurs.put("codePostal", e.getMessage());
            System.out.println("problème codePostal site");
        }
        try {
            validationVille(ville);
        } catch (Exception e) {
            erreurs.put("ville", e.getMessage());
            System.out.println("problème ville site");
        }
        try {
            validationHauteur(hauteurDuSite);
        } catch (Exception e) {
            erreurs.put("hauteurDuSite", e.getMessage());
            System.out.println("problème hauteur Du Site site");
        }
        try {
            validationAltitude(altitude);
        } catch (Exception e) {
            erreurs.put("altitudeDuSite", e.getMessage());
            System.out.println("problème altitude Du Site");
        }
        try {
            validationTempsApproche(tempsApproche);
        } catch (Exception e) {
            erreurs.put("tempsApproche", e.getMessage());
            System.out.println("problème temps Approche");
        }
        try {
            validationTypeDeRoche(typeDeRoche);
        } catch (Exception e) {
            erreurs.put("typeDeRoche", e.getMessage());
            System.out.println("problème type de roche");
        }
    }

    /**
     * Valide le nom du site
     * @param pNom
     * @throws Exception
     */
    private void validationNomSite(String pNom) throws Exception{
        if (pNom == null && pNom.trim().length() == 0) {
            throw new Exception("Le nom est vide");
        }else if(pNom.trim().length() <= 2 || pNom.trim().length() >= 20){
            throw new Exception("Le nom doit être composé de 2 caractères minimum et de 20 maximum");
        }
   }

    /**
     * Valide l'adresse postale saisie
     * @param pAdresse
     * @throws Exception
     */
    private void validationAdressePostale(String pAdresse) throws Exception {
        if (pAdresse.isEmpty()) {
            throw new Exception("L'adresse n'est pas renseignée");
        }else if(pAdresse.trim().length() <= 2 || pAdresse.trim().length() >= 30){
            throw new Exception("L'adresse doit être composée de 2 caractères minimum et de 30 maximum");
        }
    }

    /**
     * Valide le code postal saisie
     * @param pCodePostal
     * @throws Exception
     */
    private void validationCodePostal(String pCodePostal) throws Exception{
        if(pCodePostal.isEmpty()) {
            throw new Exception("Le code Postal n'est pas renseigné");
        }else if(pCodePostal.trim().length() < 5 || pCodePostal.trim().length() >= 10){
            throw new Exception("Le code postal doit être composé de 5 caractères minimum et de 10 maximum");
        }
    }

    /**
     * Valide la ville saisie
     * @param pHauteur
     * @throws Exception
     */
    private void validationHauteur(String pHauteur) throws Exception{
        if(pHauteur.isEmpty()){
            throw  new Exception("La hauteur du site n'est pas renseignée");
        }else if(pHauteur.trim().length() <= 2 || pHauteur.trim().length() >= 5){
            throw new Exception("La hauteur doit être comprise entre 2 et 5 entiers");
        }else if(!NumberUtils.isNumber(pHauteur)) {
            throw new Exception("La hauteur ne comporte que des nombres entiers");
        }
    }

    /**
     * Valide la ville saisie
     * @param pAltitude
     * @throws Exception
     */
    private void validationAltitude(String pAltitude) throws Exception{
        if(pAltitude.isEmpty()){
            throw  new Exception("L'altitude du site n'est pas renseignée");
        }else if(pAltitude.trim().length() <= 2 || pAltitude.trim().length() >= 5){
            throw new Exception("L'altitude doit être comprise entre 2 et 5 entiers");
        }else if(!NumberUtils.isNumber(pAltitude)) {
            throw new Exception("L'altitude ne comporte que des nombres entiers");
        }
    }

    /**
     * Valide la ville saisie
     * @param pVille
     * @throws Exception
     */
    private void validationVille(String pVille) throws Exception{
        if(pVille.isEmpty()){
            throw  new Exception("La ville n'est pas renseignée");
        }else if(pVille.trim().length() <= 2 || pVille.trim().length() >= 25){
            throw new Exception("La ville doit être composée de 2 caractères minimum et de 25 maximum");
        }
    }

    /**
     * Valide l'adresse postale saisie
     * @param pTempsDApproche
     * @throws Exception
     */
    private void validationTempsApproche(String pTempsDApproche) throws Exception {
        if (pTempsDApproche.isEmpty()) {
            throw new Exception("Le temps d'approche n'est pas renseignée");
        }else if(pTempsDApproche.trim().length() <= 2 || pTempsDApproche.trim().length() >= 30){
            throw new Exception("Le temps d'approche doit être composée de 2 caractères minimum et de 30 maximum");
        }
    }

    /**
     * Valide l'adresse postale saisie
     * @param pRoche
     * @throws Exception
     */
    private void validationTypeDeRoche(String pRoche) throws Exception {
        if (pRoche.isEmpty()) {
            throw new Exception("Le temps d'approche n'est pas renseignée");
        }else if(pRoche.trim().length() <= 2 || pRoche.trim().length() >= 20){
            throw new Exception("Le temps d'approche doit être composée de 2 caractères minimum et de 20 maximum");
        }
    }

    /**
     * Valide l'adresse postale saisie
     * @param pNomSecteur
     * @throws Exception
     */
    private void validationSecteur(String pNomSecteur) throws Exception {
        if (pNomSecteur.isEmpty()) {
            throw new Exception("Le nom du secteur n'est pas renseignée");
        }else if(pNomSecteur.trim().length() <= 2 || pNomSecteur.trim().length() >= 20){
            throw new Exception("Le nom du secteur doit être composée de 2 caractères minimum et de 20 maximum");
        }
    }

    /**
     * Valide l'adresse postale saisie
     * @param pNomVoie
     * @throws Exception
     */
    private void validationNomVoie(String pNomVoie) throws Exception {
        if (pNomVoie.isEmpty()) {
            throw new Exception("Le nom du secteur n'est pas renseignée");
        }else if(pNomVoie.trim().length() <= 2 || pNomVoie.trim().length() >= 20){
            throw new Exception("Le nom du secteur doit être composée de 2 caractères minimum et de 20 maximum");
        }
    }

    /**
     * Valide l'adresse postale saisie
     * @param pNumeroVoie
     * @throws Exception
     */
    private void validationNumeroDeVoie(String pNumeroVoie) throws Exception {
        if (pNumeroVoie.isEmpty()) {
            throw new Exception("Le numero de voie n'est pas renseignée");
        }else if(pNumeroVoie.trim().length() <= 1 || pNumeroVoie.trim().length() >= 10){
            throw new Exception("Le numero de voie doit être composée de 1 caractères minimum et de 10 maximum");
        }
    }

    private int affichagePageEnFonctionDeLUtilisateur() {
        int indice;
        /*permet d'afficher les différents élément de la page en fonction de l'avancer de l'inscription*/
        if(utilisateur == null) {
            indice = -1;
        }else if (utilisateur.getAdresse() == null){
            indice = 0;
        }else{
            indice = utilisateur.getAdresse().getIdAdresse();
        }
        return indice;
    }

    private void affichageDesListesDeroulantes() {
        listeDesCotations = new ArrayList<>();
        listeDesOrientations = new ArrayList<>();
        listeDesPays = new ArrayList<>();
        siteRessource = new SiteRessource();
        paysRessource = new PaysRessource();

        /*appel de la liste des cotations*/
        listeDesCotations = siteRessource.readAllCotation();

        /*appel de la liste des orientations*/
        listeDesOrientations = siteRessource.readAllOrientation();

        /*ajout des pays*/
        listeDesPays = paysRessource.readAllPays();
    }

    private void verificationDesSaisiesSecteurVoie(HttpServletRequest request){
        nomSecteur = request.getParameter("secteur");
        numeroVoie = request.getParameter("numeroVoie");
        nomVoie = request.getParameter("voie");
        cotationString = request.getParameter("cotation");

        try {
            validationSecteur(nomSecteur);
        } catch (Exception e) {
            erreurs.put("nomSecteur", e.getMessage());
            System.out.println("problème nom secteur");
        }
        try {
            validationSecteur(nomSecteur);
        } catch (Exception e) {
            erreurs.put("numeroVoie", e.getMessage());
            System.out.println("problème numero Voie");
        }
        try {
            validationSecteur(nomSecteur);
        } catch (Exception e) {
            erreurs.put("nomVoie", e.getMessage());
            System.out.println("problème nom  Voie");
        }
    }

    private String[] ajoutDUneVoie(){
        String[] ensembleSecteurVoie = {nomSecteur, numeroVoie, nomVoie, cotationString};

        return ensembleSecteurVoie;
    }


}
