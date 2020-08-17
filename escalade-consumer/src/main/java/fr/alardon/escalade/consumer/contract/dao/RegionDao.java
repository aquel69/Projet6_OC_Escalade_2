package fr.alardon.escalade.consumer.contract.dao;

import fr.alardon.escalade.bean.referentiel.Region;

import java.util.List;

public interface RegionDao {
    /**
     *
     * @return la liste de toutes les régions
     */
    public List<Region> readAllRegion();

    /**
     *
     * @param nom
     * @return la région complète en fonction de son nom
     */
    public Region read(String nom);

    /**
     *
     * @param id
     * @return la région complète en fonction de son id
     */
    public Region read(int id);
}
