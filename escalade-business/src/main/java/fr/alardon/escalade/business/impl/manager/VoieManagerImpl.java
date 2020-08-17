package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.referentiel.Cotation;
import fr.alardon.escalade.bean.site.Secteur;
import fr.alardon.escalade.bean.site.Voie;
import fr.alardon.escalade.business.contract.manager.VoieManager;

import javax.inject.Named;
import java.util.List;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager {


    @Override
    public List<Voie> readVoieRapportSite(int pIdSite) {return getDaoFactory().getVoieDao().readVoieRapportSite(pIdSite);}

    @Override
    public Integer ajouterUneVoie(Voie voie, Secteur secteur, Cotation cotation){return getDaoFactory().getVoieDao().ajouterUneVoie(voie, secteur, cotation);}
}
