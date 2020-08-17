package fr.alardon.escalade.webapp.ressource.adresse;

import fr.alardon.escalade.bean.referentiel.Departement;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class DepartementRessource extends AbstractRessource {
    public List<Departement> readAllDepartement(){return getManagerFactory().getDepartementManager().readAllDepartement();}

    public Departement read(String pNom){return getManagerFactory().getDepartementManager().read(pNom);}

    public Departement read(int pId){return getManagerFactory().getDepartementManager().read(pId);}
}
