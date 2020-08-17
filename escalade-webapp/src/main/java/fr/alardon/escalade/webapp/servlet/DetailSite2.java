package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireSiteEscalade;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.site.Voie;
import fr.alardon.escalade.bean.topo.ListeTopoSite;
import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.webapp.ressource.escalade.CommentaireRessource;
import fr.alardon.escalade.webapp.ressource.escalade.ListeCommentaireRessource;
import fr.alardon.escalade.webapp.ressource.escalade.SiteRessource;
import fr.alardon.escalade.webapp.ressource.escalade.VoieRessource;
import fr.alardon.escalade.webapp.ressource.photo.ListePhotoRessource;
import fr.alardon.escalade.webapp.ressource.photo.PhotoRessource;
import fr.alardon.escalade.webapp.ressource.topo.ListeTopoRessource;
import fr.alardon.escalade.webapp.ressource.topo.TopoRessource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DetailSite2")
public class DetailSite2 extends HttpServlet {
    public static final int TAILLE_TAMPON = 10240;
    /*public static final String CHEMIN_FICHIERS = "D:/HOMEWORK/projetMaven/projet6_escalade/escalade-webapp/src/main/webapp/site-web/photoServeur/photos/"; // A changer*/
    public static final String CHEMIN_FICHIERS = "C:/Users/alex/Desktop/Projet6_OC_Escalade-master/escalade-webapp/src/main/webapp/site-web/photoServeur/photos/";

    /*variables de classe*/
    private SiteEscalade siteEscalade;
    private SiteRessource siteRessource;
    private List<Voie> listeDesVoies;
    private List<UrlPhoto> listeDesPhotos;
    private List<ListeCommentaireSiteEscalade> listeDesCommentaires;
    private List<ListeTopoSite> listeDesToposDuSite;
    private VoieRessource voieRessource;
    private PhotoRessource photoRessource;
    private ListeCommentaireRessource listeCommentaireRessource;
    private ListeTopoRessource listeTopoRessource;
    private String[] listeDesToposRecuperer = null;
    private String premierePhotoListe = null;
    private String premierCommentaire = null;
    private String erreurPhoto = null;
    private Utilisateur utilisateur;
    private HttpSession session;
    private Object objRecuperationSession;
    private Part part = null;
    private Map<String, String> erreurs;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do get detail site 2"));
        siteEscalade = new SiteEscalade();
        siteRessource = new SiteRessource();
        listeDesVoies = new ArrayList<>();
        listeDesPhotos = new ArrayList<>();
        listeDesCommentaires = new ArrayList<>();
        listeDesToposDuSite = new ArrayList<>();
        voieRessource = new VoieRessource();
        photoRessource = new PhotoRessource();
        listeCommentaireRessource = new ListeCommentaireRessource();
        listeTopoRessource = new ListeTopoRessource();

        /*récuperation de l'id site en paramètre*/
        String idSite = request.getParameter("site");
        siteEscalade = siteRessource.read(Integer.parseInt(idSite));
        System.out.println(siteEscalade.toString());

        /*liste des voies, des photos et des commentaires correspondant à l'id site*/
        listeDesVoies = voieRessource.readVoieRapportSite(Integer.parseInt(idSite));
        listeDesPhotos = photoRessource.readAllPhotoParSite(Integer.parseInt(idSite));
        listeDesCommentaires = listeCommentaireRessource.readListeCommentaire(Integer.parseInt(idSite));
        listeDesToposDuSite = listeTopoRessource.readListeTopoParSite(Integer.parseInt(idSite));

        if(!listeDesPhotos.isEmpty()) {
            premierePhotoListe = listeDesPhotos.get(0).getUrl();
            premierCommentaire = listeDesPhotos.get(0).getDescription();
        }

        /*envoi à la jsp*/
        request.setAttribute("premierePhoto", premierePhotoListe);
        request.setAttribute("premierCommentaire", premierCommentaire);
        request.setAttribute("listeDesTopos", listeDesToposDuSite);
        request.setAttribute("siteDetail", siteEscalade);
        request.setAttribute("listeDesVoies", listeDesVoies);
        request.setAttribute("listeDesPhotos", listeDesPhotos);
        request.setAttribute("listeDesCommentaires", listeDesCommentaires);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/detailSite.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do get detail site 2"));

        String erreurUtilisateur = null;

        /*récupération de l'utilisateur de la session*/
        utilisateur = new Utilisateur();
        session = request.getSession(false);
        objRecuperationSession = session.getAttribute("utilisateur");
        utilisateur = (Utilisateur) objRecuperationSession;

        System.out.println("btn envoyer photo " + request.getParameter("btPhoto"));

        if(utilisateur != null) {
            /*commentaire*/
            if (request.getParameter("btValiderCommentaire") != null) {
                ajoutDUnCommentaire(request);
            }

            if (request.getParameter("btTopo") != null) {
                reservationDUnTopo(request);
            }

            if (request.getParameter("btPhoto") != null) {
                ajoutDUnePhoto(request);
            }

            /*mise à jours des différentes listes*/
            miseAjourDesListes();
        }else {
            erreurUtilisateur = "Vous avez besoin d'être connecté pour intéragir avec cette page";
        }

        /*envoi à la jsp*/
        request.setAttribute("erreurs", erreurs);
        request.setAttribute("erreurPhoto", erreurPhoto);
        request.setAttribute("erreurUtilisateur", erreurUtilisateur);
        request.setAttribute("premierePhoto", premierePhotoListe);
        request.setAttribute("premierCommentaire", premierCommentaire);
        request.setAttribute("listeDesTopos", listeDesToposDuSite);
        request.setAttribute("siteDetail", siteEscalade);
        request.setAttribute("listeDesVoies", listeDesVoies);
        request.setAttribute("listeDesPhotos", listeDesPhotos);
        request.setAttribute("listeDesCommentaires", listeDesCommentaires);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/detailSite.jsp").forward(request, response);
    }

    private void ajoutDUnePhoto(HttpServletRequest request) throws IOException, ServletException {
        String description = null;
        String nomFichier = null;
        String nomFichierComplet = null;

        boolean isthereafile = false;

        UrlPhoto urlPhoto = new UrlPhoto();
        ListePhotoRessource listePhotoRessource = new ListePhotoRessource();


        // On récupère le champ description comme d'habitude
        description = request.getParameter("description");

        try {
            part = request.getPart("fichier");
            isthereafile = true;
        } catch (Exception e) {
            isthereafile = false;
        }

        if (isthereafile && !description.isEmpty()) {
            // On récupère le champ du fichier
            part = request.getPart("fichier");

            // On vérifie qu'on a bien reçu un fichier
            nomFichier = getNomFichier(part);

            if(nomFichier.length() > 25)
                erreurPhoto = "Le nom de la photo doit être inférieur à 25 caractères";
        }

        if (isthereafile && description.isEmpty())
            erreurPhoto = "Le champs description est vide";


        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty() && nomFichier.length() <= 25){

            String nomChamp = part.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
            nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                    .substring(nomFichier.lastIndexOf('\\') + 1);

            // On écrit définitivement le fichier sur le disque
            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

            request.setAttribute(nomChamp, nomFichier);

            nomFichierComplet = "./site-web/photoServeur/photos/" + nomFichier;

            if (!photoRessource.comparaisonUrlPhoto(nomFichierComplet) && !nomFichier.isEmpty()) {
                erreurPhoto = null;

                urlPhoto.setDescription(description);
                urlPhoto.setUrl("./site-web/photoServeur/photos/" + nomFichier);

                if (urlPhoto.getUrl() != null)
                    photoRessource.ajouterUnePhoto(urlPhoto);

                /*recuperation du dernier id*/
                int dernierIdPhoto = photoRessource.idDernierePhoto();
                urlPhoto.setIdUrl(dernierIdPhoto);
                /*ajout de la photo dans la liste*/
                listePhotoRessource.ajouterUnePhotoALaListe(urlPhoto, siteEscalade);

            } else {
                erreurPhoto = "le nom de l'image est déjà existante ou non valide";
            }
            listeDesPhotos = photoRessource.readAllPhotoParSite(siteEscalade.getIdSite());
        }
    }


    private void reservationDUnTopo(HttpServletRequest request){
        TopoRessource topoRessource = new TopoRessource();
        /* recuperation de l'id des checkbox*/
        listeDesToposRecuperer = request.getParameterValues("topo");
        if (listeDesToposRecuperer != null) {
            for (String idTopo : listeDesToposRecuperer) {
                Topo topo = new Topo();
                topo = topoRessource.read(Integer.parseInt(idTopo));
                topo.setDemandeReservation(true);
                topoRessource.ajouterUneReservationTopo(topo, utilisateur);
                if (topo.isDisponibilite() == true) {
                    topo.setDisponibilite(false);
                    topoRessource.modifierDisponibiliteDUnTopo(topo);
                } else {
                    topo.setDisponibilite(true);
                    topoRessource.modifierDisponibiliteDUnTopo(topo);
                }
            }
        }
    }

    /**
     * ajouter un commentaire
     * @param request
     */
    private void ajoutDUnCommentaire(HttpServletRequest request){
        String commentaireRecuperer = null;
        Commentaire commentaire = new Commentaire();
        LocalDateTime dateTime = LocalDateTime.now();
        CommentaireRessource commentaireRessource = new CommentaireRessource();
        erreurs = new HashMap<String, String>();

        /*ajout du commentaire*/
        commentaireRecuperer = request.getParameter("commentaireRecuperer");
        try {
            validationCommentaire(commentaireRecuperer);
        } catch (Exception e) {
            erreurs.put("commentaire", e.getMessage());
            System.out.println("problème commentaire");
        }
        if(erreurs.isEmpty()) {
            /*on ajoute au beans le commmentaire, l'utilisateur, la date*/
            commentaire.setCommentaire(commentaireRecuperer);
            commentaire.setUtilisateur(utilisateur);
            commentaire.setDate(dateTime);
            /*on ajoute le commentaire dans la base de donnée*/
            commentaireRessource.ajouterUnCommentaire(commentaire);
            /*on récupère l'id du commentaire*/
            int idDernierCommentaire = commentaireRessource.idDernierCommentaire();
            /*on ajoute l'id au bean*/
            commentaire.setIdCommentaire(idDernierCommentaire);
            /*on ajoute le commentaire à la table liste commentaire site escalade*/
            listeCommentaireRessource.ajouterUnCommentaireALaListe(commentaire, siteEscalade);
        }
    }

    /**
     * mise à jour des différentes listes
     */
    private void miseAjourDesListes(){
        /*liste des voies, des photos et des commentaires correspondant à l'id site*/
        listeDesVoies = voieRessource.readVoieRapportSite(siteEscalade.getIdSite());
        listeDesPhotos = photoRessource.readAllPhotoParSite(siteEscalade.getIdSite());
        listeDesCommentaires = listeCommentaireRessource.readListeCommentaire(siteEscalade.getIdSite());
        listeDesToposDuSite = listeTopoRessource.readListeTopoParSite(siteEscalade.getIdSite());
    }

    /**
     * vérification de la saisie commentaire
     * @param commentaire
     * @throws Exception
     */
    private void validationCommentaire(String commentaire) throws Exception{
        if( commentaire == null || commentaire.trim().length() == 0 ){
            throw  new Exception("Le commentaire est vide");

        }
        if(commentaire.trim().length() > 200){
            throw  new Exception("Le commentaire doit faire moins de 200 caractères");
        }
    }

    /**
     *
     * @param part
     * @param nomFichier
     * @param chemin
     * @throws IOException
     */
    private void ecrireFichier(Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        /*try {*/
        entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
        sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

        byte[] tampon = new byte[TAILLE_TAMPON];
        int longueur;
        while ((longueur = entree.read(tampon)) > 0) {
            sortie.write(tampon, 0, longueur);
        }
    }

    /**
     *
     * @param part
     * @return
     */
    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }
}
