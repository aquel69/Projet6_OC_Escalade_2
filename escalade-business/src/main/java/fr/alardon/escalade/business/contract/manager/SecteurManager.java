package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.SiteEscalade;

import java.util.List;

public interface SecteurManager {

    public int getNbSecteur(int id);

    public Secteur read(int id);

    public List<Secteur> readAllSecteur();

    public Integer ajouterUnSecteur(Secteur secteur, SiteEscalade siteEscalade);

    public int idDernierSecteur();

}
