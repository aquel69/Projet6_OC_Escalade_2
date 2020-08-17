package fr.alardon.escalade.webapp.ressource.escalade;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.Voie;
import fr.alardon.escalade.webapp.ressource.adresse.AdresseRessource;

import java.util.List;

public class VoieRessource extends AdresseRessource {

    public List<Voie> readVoieRapportSite(int pIdSite){return getManagerFactory().getVoieManager().readVoieRapportSite(pIdSite);}

    public Integer ajouterUneVoie(Voie voie, Secteur secteur, Cotation cotation){return getManagerFactory().getVoieManager().ajouterUneVoie(voie, secteur, cotation);}

}
