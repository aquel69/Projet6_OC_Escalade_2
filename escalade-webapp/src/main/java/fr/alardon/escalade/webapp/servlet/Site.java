package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.photo.ListePhotoSite;
import fr.alardon.escalade.bean.photo.UrlPhoto;
import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.bean.site.Voie;
import fr.alardon.escalade.webapp.ressource.escalade.SecteurRessource;
import fr.alardon.escalade.webapp.ressource.escalade.SiteRessource;
import fr.alardon.escalade.webapp.ressource.escalade.VoieRessource;
import fr.alardon.escalade.webapp.ressource.photo.ListePhotoRessource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Site")
public class Site extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    System.out.println(("do get site"));

    Secteur secteur = new Secteur();
    SiteRessource siteRessource = new SiteRessource();
    List <SiteEscalade> listeDesSiteDEscalade;

    listeDesSiteDEscalade = siteRessource.readAllSiteEscalade();

    request.setAttribute("secteur", secteur);
    request.setAttribute("listeDesSites", listeDesSiteDEscalade);

    this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/lesSites.jsp").forward(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    System.out.println("do post site");


    this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/lesSites.jsp").forward(request, response);
}
}
