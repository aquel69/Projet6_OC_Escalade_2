package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.Voie;

import java.util.List;

public interface VoieManager {

    public List<Voie> readVoieRapportSite(int idSite);

    public Integer ajouterUneVoie(Voie voie, Secteur secteur, Cotation cotation);

}
