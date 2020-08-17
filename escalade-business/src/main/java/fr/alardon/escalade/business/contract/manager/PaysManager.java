package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.referentiel.Pays;

import java.util.List;

public interface PaysManager {
    public List<Pays> readAllPays();

    public Pays read(int id);

    public Pays read(String nom);
}
