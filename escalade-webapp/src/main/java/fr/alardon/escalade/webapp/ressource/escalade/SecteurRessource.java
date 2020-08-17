package fr.alardon.escalade.webapp.ressource.escalade;

import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.SiteEscalade;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class SecteurRessource extends AbstractRessource {

    public int getNbSecteur(int id){return getManagerFactory().getSecteurManager().getNbSecteur(id);}

    public Secteur read(int id){return getManagerFactory().getSecteurManager().read(id);}

    public List<Secteur> readAllSecteur(){return getManagerFactory().getSecteurManager().readAllSecteur();}

    public Integer ajouterUnSecteur(Secteur secteur, SiteEscalade siteEscalade){return getManagerFactory().getSecteurManager().ajouterUnSecteur(secteur, siteEscalade);}

    public int idDernierSecteur(){return getManagerFactory().getSecteurManager().idDernierSecteur();}
}
