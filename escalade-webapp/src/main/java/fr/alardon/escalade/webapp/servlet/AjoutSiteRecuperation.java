package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.adresse.Adresse;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireTopo;
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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AjoutSiteRecuperation extends HttpServlet {

    private List<String> listCotation;
    private List<String> listeOrientation;
    private SiteRessource siteRessource = new SiteRessource();
    private PaysRessource paysRessource = new PaysRessource();
    private List<Pays> listeDesPays = new ArrayList<>();
    private List<Cotation> listeDesCotations = new ArrayList<>();
    private List<String[]> listeDesVoies = new ArrayList<>();
    private List<Orientation> listeDesOrientations = new ArrayList<>();
    int affichagePage = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do get ajoutSite"));

        Utilisateur utilisateur = new Utilisateur();
        HttpSession session = request.getSession(false);
        Object obj = session.getAttribute("utilisateur");
        utilisateur = (Utilisateur) obj;

        affichageDesListesDeroulantes();

        affchagePageEnFonctionDeLUtilisateur(utilisateur);

        /*envoi à la jsp*/
        request.setAttribute("listeDesCotations", listeDesCotations);
        request.setAttribute("listeDesOrientations", listeDesOrientations);
        request.setAttribute("listeDesPays", listeDesPays);
        request.setAttribute("affichagePage", affichagePage);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajoutSite.jsp").forward(request, response);
    }

    private void affichageDesListesDeroulantes() {
        /*appel de la liste des cotations*/
        listeDesCotations = siteRessource.readAllCotation();

        /*appel de la liste des orientations*/
        listeDesOrientations = siteRessource.readAllOrientation();

        /*ajout des pays*/
        listeDesPays = paysRessource.readAllPays();
    }

    private void affchagePageEnFonctionDeLUtilisateur(Utilisateur utilisateur) {
        /*permet d'afficher les différents élément de la page en fonction de l'avancer de l'inscription*/
        if(utilisateur == null) {
            affichagePage = -1;
        }else if (utilisateur.getAdresse() == null){
            affichagePage = 0;
        }else{
            affichagePage = utilisateur.getAdresse().getIdAdresse();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("do post ajoutSite");

        String nomSecteur = null;
        String numeroVoie = null;
        String nomVoie = null;
        String nom = null;
        String adresse = null;
        String ville = null;
        String codePostal = null;
        String altitude = null;
        String orientationString = null;
        String cotationString = null;
        String hauteurDuSite = null;
        String tempsApproche = null;
        String typeDeRoche = null;
        String nomPays = null;
        Pays pays = new Pays();
        Secteur secteurGlobal = new Secteur();
        Voie voieGlobale = new Voie();
        SecteurRessource secteurRessource = new SecteurRessource();
        VoieRessource voieRessource = new VoieRessource();
        PaysRessource paysRessource = new PaysRessource();
        SiteEscalade siteEscalade = new SiteEscalade();
        Adresse adresseComplete = new Adresse();
        AdresseRessource adresseRessource = new AdresseRessource();
        Orientation orientation = new Orientation();
        Cotation cotation = new Cotation();

        /*récupération de l'objet utilisateur de la session dans la variable utilisateur*/
        Utilisateur utilisateur = new Utilisateur();
        HttpSession session = request.getSession(false);
        Object obj = session.getAttribute("utilisateur");
        utilisateur = (Utilisateur) obj;

//        if (utilisateur != null){
            nomSecteur = request.getParameter("secteur");
            numeroVoie = request.getParameter("numeroVoie");
            nomVoie = request.getParameter("voie");
            cotationString = request.getParameter("cotation");

            if (nomSecteur != null && numeroVoie != null && nomVoie != null && cotationString != null) {
                String[] ensembleSecteurVoie = {nomSecteur, numeroVoie, nomVoie, cotationString};
                listeDesVoies.add(ensembleSecteurVoie);
            }

            request.setAttribute("affichagePage", affichagePage);
            request.setAttribute("listeDesVoies", listeDesVoies);
            request.setAttribute("listeDesCotations", listeDesCotations);
            request.setAttribute("listeDesPays", listeDesPays);
            request.setAttribute("listeDesOrientations", listeDesOrientations);

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

        for (String[] p: listeDesVoies){
            System.out.println("liste des voie " + p);
        }

        System.out.println("ajout " + nom + adresse + ville + codePostal + nomPays);

            if (nom != null && adresse != null && ville != null && codePostal != null  && listeDesVoies != null) {
                System.out.println("dans la fonction ajout");
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

                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
//        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajoutSite.jsp").forward(request, response);
    }

}
