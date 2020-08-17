package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.referentiel.Region;

import java.util.List;

public interface RegionManager {
    public List<Region> readAllRegion();

    public Region read(String pNom);

    public Region read(int id);
}
