package fr.alardon.escalade.webapp.ressource.adresse;


import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class RegionRessource extends AbstractRessource {
    public List<Region> readAllRegion(){return getManagerFactory().getRegionManager().readAllRegion();}

    public Region read(String pNom){return  getManagerFactory().getRegionManager().read(pNom);}

    public Region read(int id){return getManagerFactory().getRegionManager().read(id);}
}
