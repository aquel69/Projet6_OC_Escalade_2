package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.business.contract.manager.RegionManager;

import javax.inject.Named;
import java.util.List;

@Named
public class RegionManagerImpl extends AbstractManager implements RegionManager {
    @Override
    public List<Region> readAllRegion() {return getDaoFactory().getRegionDao().readAllRegion();}

    @Override
    public Region read(String pNom) {return getDaoFactory().getRegionDao().read(pNom);}

    @Override
    public Region read(int id) {return getDaoFactory().getRegionDao().read(id);}


}
