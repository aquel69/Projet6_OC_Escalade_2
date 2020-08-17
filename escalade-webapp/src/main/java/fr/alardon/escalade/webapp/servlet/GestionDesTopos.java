package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireTopo;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.webapp.ressource.escalade.CommentaireRessource;
import fr.alardon.escalade.webapp.ressource.escalade.ListeCommentaireRessource;
import fr.alardon.escalade.webapp.ressource.escalade.SiteRessource;
import fr.alardon.escalade.webapp.ressource.topo.ListeTopoRessource;
import fr.alardon.escalade.webapp.ressource.topo.TopoRessource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "gestionDesTopos")
public class GestionDesTopos extends HttpServlet {

    /*variables classe*/
    private Utilisateur utilisateur;
    private HttpSession session;
    private Object objRecuperationSession;
    private int indiceVue = 0;
    private String nomDuTopoChoisi = null;
    private String idMonTopoChoisi = null;
    private String idTopoEmprunt = null;
    private List<Topo> listeDesToposAppartenantALUtilisateur;
    private List<Topo> listeDesToposEmprunteParLUtilisateur;
    private List<Topo> listeDeTousLesTopos;
    private List<SiteEscalade> listeSitesEscalade;
    private List<ListeCommentaireTopo> listeCommentaireTopos;
    private TopoRessource topoRessource;
    private SiteRessource siteRessource;
    private CommentaireRessource commentaireRessource;
    private ListeCommentaireRessource listeCommentaireRessource;
    private Map<String, String> erreurs;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do get gestion des topos"));

        /*variables doGet*/
        listeSitesEscalade = new ArrayList<>();
        listeDesToposAppartenantALUtilisateur = new ArrayList<>();
        listeDesToposEmprunteParLUtilisateur = new ArrayList<>();
        listeDeTousLesTopos = new ArrayList<>();
        siteRessource = new SiteRessource();
        topoRessource = new TopoRessource();

        /*récupération de l'utilisateur de la session*/
        utilisateur = new Utilisateur();
        session = request.getSession(false);
        objRecuperationSession = session.getAttribute("utilisateur");
        utilisateur = (Utilisateur) objRecuperationSession;

        /*permet d'afficher les différents élément de la page en fonction de l'avancer de l'inscription*/
        affichageDesDifférentesVuesSelonConnectionUtilisateur();

        /*Ajout des Sites d'escalade dans la partie ajout Topo*/
        listeSitesEscalade = siteRessource.readAllSiteEscalade();

        /*ajout des topos appartenant à l'utilisateur*/
        if(utilisateur != null) listeDesToposAppartenantALUtilisateur = topoRessource.readListeTopoParUtilisateur(utilisateur.getIdUtilisateur());

        /*ajout des topos empruntés par l'utilisateur*/
        affichageDesToposEmprunteParLUtilisateur();

        /*envoi à la JSP*/
        request.setAttribute("indiceVue", indiceVue);
        request.setAttribute("listeDesSites", listeSitesEscalade);
        request.setAttribute("listeDesTopos", listeDesToposAppartenantALUtilisateur);
        request.setAttribute("listeDesToposEmprunte", listeDesToposEmprunteParLUtilisateur);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/gestionDesTopos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do post gestion des topos"));

        /*variables do Post*/
        Commentaire commentaire = new Commentaire();
        Topo topo = new Topo();
        listeCommentaireRessource = new ListeCommentaireRessource();

        erreurs = new HashMap<String, String>();

        /*commentaire*/
        if(request.getParameter("btChoisirMonTopo") != null && request.getParameter("accesTopo") != null){
            idMonTopoChoisi = null;
            idTopoEmprunt = null;
            listeCommentaireTopos = new ArrayList<>();
            idMonTopoChoisi = request.getParameter("accesTopo");
            listeCommentaireTopos = ajoutDeLaListeDesCommentairesDuTopo(idMonTopoChoisi);
            topo = topoRessource.read(Integer.parseInt(idMonTopoChoisi));
            nomDuTopoChoisi = topo.getNom();

        }else if (request.getParameter("btChoisirTopoEmprunt") != null && request.getParameter("accesTopoPret") != null){
            idTopoEmprunt = null;
            idMonTopoChoisi = null;
            listeCommentaireTopos = new ArrayList<>();
            idTopoEmprunt = request.getParameter("accesTopoPret");
            listeCommentaireTopos = ajoutDeLaListeDesCommentairesDuTopo(idTopoEmprunt);
            topo = topoRessource.read(Integer.parseInt(idTopoEmprunt));
            nomDuTopoChoisi = topo.getNom();

        }else if(request.getParameter("btRecupererCommentaire") != null && request.getParameter("commentaireRecuperer") != null && idMonTopoChoisi != null){
            ajouterLeCommentaireALaListe(request, commentaire, idMonTopoChoisi);
        }else if(request.getParameter("btRecupererCommentaire") != null && request.getParameter("commentaireRecuperer") != null && idTopoEmprunt != null){
            ajouterLeCommentaireALaListe(request, commentaire, idTopoEmprunt);
        }

        /*ajout d'un topo*/
        if(request.getParameter("btAjouterUnTopo") != null){
            ajouterUnTopo(request);
        }

        /*rendre disponible un topo*/
        if(request.getParameter("btRendreDisponible") != null && request.getParameter("rendreDisponible") != null){
            modifierLaDisponibiliteDUnTopo(request);
        }

        /*envoi à la JSP*/
        request.setAttribute("erreurs", erreurs);
        request.setAttribute("indiceVue", indiceVue);
        request.setAttribute("nomDuTopoChoisi", nomDuTopoChoisi);
        request.setAttribute("listeDesSites", listeSitesEscalade);
        request.setAttribute("listeDesTopos", listeDesToposAppartenantALUtilisateur);
        request.setAttribute("listeDesToposEmprunte", listeDesToposEmprunteParLUtilisateur);
        request.setAttribute("listeDesCommentairesTopo",listeCommentaireTopos);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/gestionDesTopos.jsp").forward(request, response);
    }


    /*méthodes*/
    private void modifierLaDisponibiliteDUnTopo(HttpServletRequest request){
        String idTopoARendreDisponible = request.getParameter("rendreDisponible");
        Topo topo = new Topo();

        /*récuperation du topo et modification de sa disponibilité dans le bean et la BDD*/
        topo = topoRessource.read(Integer.parseInt(idTopoARendreDisponible));
        topo.setDisponibilite(false);
        topoRessource.modifierDisponibiliteDUnTopo(topo);
        listeDesToposAppartenantALUtilisateur = topoRessource.readListeTopoParUtilisateur(utilisateur.getIdUtilisateur());
    }

    /**
     * ajouter un topo à l'utilisateur
     * @param request
     */
    private void ajouterUnTopo(HttpServletRequest request){
        String lieuTopo = null;
        String nomTopo = null;
        String descriptionTopo = null;
        LocalDateTime dateTime = LocalDateTime.now();
        Topo topo = new Topo();
        SiteEscalade siteEscalade = new SiteEscalade();
        ListeTopoRessource listeTopoRessource = new ListeTopoRessource();

        /*recuperation des champs*/
        lieuTopo = request.getParameter("lieu");
        nomTopo = request.getParameter("nomTopo");
        descriptionTopo = request.getParameter("description");

        /*ajout du bean*/
        topo.setNom(nomTopo);
        topo.setDescription(descriptionTopo);
        topo.setDateDeParution(dateTime);
        topo.setDisponibilite(false);
        topo.setUtilisateur(utilisateur);
        topo.setLieu(lieuTopo);

        /* Validation des champs ajout topo */
        try {
            validationAjoutTopo(topo);

        } catch (Exception e) {
            erreurs.put("topo", e.getMessage());
            System.out.println("probleme topo");
        }
        System.out.println("topo ajoute " + topo.toString());
        for (Map.Entry<String, String> entry : erreurs.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " erreur : " + entry.getValue());
        }
        if(erreurs.isEmpty()) {
            /*ajout du topo dans la bdd*/
            topoRessource.ajouterUnTopo(topo, utilisateur);
            int idTopo = topoRessource.idDernierTopo();
            topo.setIdTopo(idTopo);
            /*ajout du topo à la liste*/
            siteEscalade = siteRessource.read(lieuTopo);
            listeTopoRessource.ajouterUnTopoALaListe(topo, siteEscalade);
            System.out.println("liste topo ajoute");
            listeDesToposAppartenantALUtilisateur = topoRessource.readListeTopoParUtilisateur(utilisateur.getIdUtilisateur());
            request.setAttribute("listeDesTopos", listeDesToposAppartenantALUtilisateur);
        }
    }

    /**
     * Ajouter un commentaire dans la liste des commentaires topo
     * @param request
     * @param commentaire
     * @param idTopo
     */
    private void ajouterLeCommentaireALaListe(HttpServletRequest request, Commentaire commentaire, String idTopo ) {
        String commentaireRecuperer = request.getParameter("commentaireRecuperer");
        commentaireRessource = new CommentaireRessource();
        LocalDateTime dateTime = LocalDateTime.now();

        try {
            validationCommentaire(commentaireRecuperer, idMonTopoChoisi, idTopoEmprunt);
        } catch (Exception e) {
            erreurs.put("commentaire", e.getMessage());
            System.out.println("probleme commentaire");
        }
        if (erreurs.isEmpty()) {
            commentaire.setUtilisateur(utilisateur);
            commentaire.setDate(dateTime);
            commentaire.setCommentaire(commentaireRecuperer);
            /*on ajoute le commentaire dans la base de donnée*/
            commentaireRessource.ajouterUnCommentaire(commentaire);
            /*on récupère l'id du commentaire*/
            int idDernierCommentaire = commentaireRessource.idDernierCommentaire();
            /*on ajoute l'id au bean*/
            commentaire.setIdCommentaire(idDernierCommentaire);
        }
        if(idTopo != null && erreurs.isEmpty()) {
            /*on recherche l'id du reservant*/
            Topo topo = topoRessource.readReservationTopo(Integer.parseInt(idTopo));

            listeCommentaireRessource.ajouterUnCommentaireALaListeTopo(commentaire, Integer.parseInt(idTopo), topo.getReservant().getIdUtilisateur());
            listeCommentaireTopos = listeCommentaireRessource.readListeCommentaireTopo(Integer.parseInt(idTopo), topo.getReservant().getIdUtilisateur());
            request.setAttribute("listeDesCommentairesTopo", listeCommentaireTopos);
        }
    }

    /**
     * permet le remplissage des beans topo empruntés
     */
    private void affichageDesToposEmprunteParLUtilisateur(){
        if(utilisateur != null) {
            listeDesToposEmprunteParLUtilisateur = topoRessource.readListeTopoReserveParUtilisateur(utilisateur.getIdUtilisateur());
            listeDeTousLesTopos = topoRessource.readAllTopo();

            /*ajout dans les topos reserves du nom description et lieux du topo*/
            for (Topo t : listeDesToposEmprunteParLUtilisateur) {
                for (Topo l : listeDeTousLesTopos) {
                    if (t.getIdTopo() == l.getIdTopo()) {
                        t.setNom(l.getNom());
                        t.setDescription(l.getDescription());
                        t.setLieu(l.getLieu());
                        t.setUtilisateur(l.getUtilisateur());
                    }
                }
            }
        }
    }

    /**
     *
     * @param idTopoChoisi
     * @return la liste contenant les commentaires des utilisateurs en fonction du topo
     */
    private List<ListeCommentaireTopo> ajoutDeLaListeDesCommentairesDuTopo(String idTopoChoisi){
        Topo reservationTopo = new Topo();
        List<ListeCommentaireTopo>listeCommentaireTopo = new ArrayList<>();
        listeCommentaireRessource = new ListeCommentaireRessource();

        reservationTopo = topoRessource.readReservationTopo(Integer.parseInt(idTopoChoisi));
        listeCommentaireTopo = listeCommentaireRessource.readListeCommentaireTopo(Integer.parseInt(idTopoChoisi), reservationTopo.getReservant().getIdUtilisateur());

        return listeCommentaireTopo;
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
     * recherche l'erreur dans le remplissage des champs de l'ajout d'un topo
     * @param topo
     * @throws Exception
     */
    private void validationAjoutTopo(Topo topo) throws Exception{
        if(topo.getNom().trim().length() >= 25)
            throw new Exception("Le nom du topo doit faire moins de 25 caractères");
        if(topo.getNom().trim().length() == 0)
            throw new Exception("Le champ nom du topo est vide");
        if(topo.getDescription().trim().length() >= 75)
            throw new Exception("La description du topo doit faire moins de 75 caractères");
        if(topo.getDescription().trim().length() == 0)
            throw new Exception("Le champ description est vide");
    }

    /**
     * recherche l'erreur dans le remplissage du champs des commentaires
     * @param commentaire
     * @param idTopo
     * @throws Exception
     */
    private void validationCommentaire(String commentaire, String idMonTopo, String idTopoEmprunt) throws Exception{
        if(idMonTopo == null && idTopoEmprunt == null){
            throw new Exception("Vous n'avez pas sélectionné de topo");
        }

        if(commentaire.trim().isEmpty()){
            throw new Exception("La case commentaire est vide");
        }
        if(commentaire.length() > 200 ){
            throw new Exception("Le commentaire doit faire moins de 200 caractères");
        }
    }
}
