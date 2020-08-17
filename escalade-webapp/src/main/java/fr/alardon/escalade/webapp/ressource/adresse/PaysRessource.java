package fr.alardon.escalade.webapp.ressource.adresse;

import fr.alardon.escalade.bean.referentiel.Pays;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

import java.util.List;

public class PaysRessource extends AbstractRessource {

    public List<Pays> readAllPays(){return getManagerFactory().getPaysManager().readAllPays();}

    public Pays read(int id){return getManagerFactory().getPaysManager().read(id);}

    public Pays read(String nom){return getManagerFactory().getPaysManager().read(nom);}

}
