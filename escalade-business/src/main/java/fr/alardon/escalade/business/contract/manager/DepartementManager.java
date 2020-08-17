package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.referentiel.Departement;


import java.util.List;

public interface DepartementManager {

    public List<Departement> readAllDepartement();

    public Departement read(String nom);

    public Departement read(int id);
}
