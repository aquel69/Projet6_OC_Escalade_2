package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.commentaire.Commentaire;
import fr.alardon.escalade.bean.commentaire.ListeCommentaireSiteEscalade;
import fr.alardon.escalade.bean.photo.ListePhotoSite;
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
import org.springframework.security.access.method.P;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DetailSite")
public class DetailSite extends HttpServlet {

    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "D:/HOMEWORK/projetMaven/projet6_escalade/escalade-webapp/src/main/webapp/site-web/photoServeur/photos/"; // A changer

    private SiteEscalade siteEscalade = new SiteEscalade();
    private SiteRessource siteRessource = new SiteRessource();
    private List<Voie> listeDesVoies = new ArrayList<>();
    private VoieRessource voieRessource = new VoieRessource();
    private UrlPhoto urlPhoto = new UrlPhoto();
    private PhotoRessource photoRessource = new PhotoRessource();
    private ListePhotoRessource listePhotoRessource = new ListePhotoRessource();
    private List<UrlPhoto> listeDesPhotos = new ArrayList<>();
    private CommentaireRessource commentaireRessource = new CommentaireRessource();
    private ListeCommentaireRessource listeCommentaireRessource = new ListeCommentaireRessource();
    private List<ListeCommentaireSiteEscalade> listeDesCommentaires;
    private ListeTopoRessource listeTopoRessource = new ListeTopoRessource();
    private TopoRessource topoRessource = new TopoRessource();
    private List<ListeTopoSite> listeDesToposDuSite = new ArrayList<>();
    private Commentaire commentaire = new Commentaire();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do get detail site"));

        String premierePhotoListe = null;
        String premierCommentaire = null;

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

        String premierePhotoListe = null;
        String premierCommentaire = null;

        System.out.println("do post detail site");

        String erreurUtilisateur = null;
        String erreurPhoto = null;
        String erreurCommentaire = null;
        String[] listeDesToposRecuperer = null;
        Part part = null;
        String nomFichier = null;
        String description = null;
        String nomFichierComplet = null;
        String verificationFichier = null;
        boolean isthereafile = false;
        Map<String, String> erreurs = new HashMap<String, String>();

        /*récupération de l'objet utilisateur de la session dans la variable utilisateur*/
        Utilisateur utilisateur = new Utilisateur();
        HttpSession session = request.getSession(false);
        Object obj = session.getAttribute("utilisateur");
        utilisateur = (Utilisateur) obj;


        /* on récupère le commentaire de la jsp*/
        String commentaireRecuperer = request.getParameter("commentaireRecuperer");
        LocalDateTime dateTime = LocalDateTime.now();
        /* recuperation de l'id des checkbox*/
        listeDesToposRecuperer = request.getParameterValues("topo");

        if(utilisateur != null && commentaireRecuperer !=null) {
            try {
                validationCommentaire(commentaireRecuperer);
            } catch (Exception e) {
                erreurs.put("commentaire", e.getMessage());
                System.out.println("problème commentaire");
            }
        }

        if(utilisateur != null) {
            if(erreurs.isEmpty()) {
                erreurUtilisateur = null;

                if(commentaireRecuperer != null && commentaireRecuperer.trim().length() != 0) {
                    /*ajout du commentaire*/
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


                /*modification de la disponibilite de la liste des topo a partir des checkbox*/
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

                /*liste des voies, des photos et des commentaires correspondant à l'id site*/
                listeDesVoies = voieRessource.readVoieRapportSite(siteEscalade.getIdSite());
                listeDesPhotos = photoRessource.readAllPhotoParSite(siteEscalade.getIdSite());
                listeDesCommentaires = listeCommentaireRessource.readListeCommentaire(siteEscalade.getIdSite());
                listeDesToposDuSite = listeTopoRessource.readListeTopoParSite(siteEscalade.getIdSite());




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
        }else{
            erreurUtilisateur = "Vous avez besoin d'être connecté pour intéragir avec cette page";
        }

        /*ajout des photos dans la liste*/
        listeDesPhotos = null;
        listeDesPhotos = photoRessource.readAllPhotoParSite(siteEscalade.getIdSite());

        /*première photo de la liste pour le carousel*/
        if (!listeDesPhotos.isEmpty()) {
            premierePhotoListe = listeDesPhotos.get(0).getUrl();
            premierCommentaire = listeDesPhotos.get(0).getDescription();
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

    private void validationCommentaire(String commentaire) throws Exception{
        if( commentaire == null || commentaire.trim().length() == 0 ){
            throw  new Exception("Le commentaire est vide");

        }
        if(commentaire.trim().length() > 200){
            throw  new Exception("Le commentaire doit faire moins de 200 caractères");
        }

    }

//    private void validationTopo(List<Topo> listeTopo) throws Exception{
//
//        for(Topo topo:listeTopo){
//            iftopo.
//        }
//        if( commentaire == null || commentaire.trim().length() == 0 ){
//            throw  new Exception("Le commentaire est vide");
//
//        }
//        if(commentaire.trim().length() > 200){
//            throw  new Exception("Le commentaire doit faire moins de 200 caractères");
//        }
//
//    }

    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
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
        /*} finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }*/
    }

    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }
}
